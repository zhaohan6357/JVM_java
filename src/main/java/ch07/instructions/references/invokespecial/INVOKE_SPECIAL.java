package ch07.instructions.references.invokespecial;

import ch07.instructions.base.method_invoke_logic.InvokeMethod;
import ch07.rtda.heap.*;
import ch07.rtda.heap.Class;
import ch07.rtda.heap.Object;
import ch07.rtda.heap.constant_pool.ConstantPool;
import ch07.instructions.base.instruction.Index16Instruction;
import ch07.rtda.Frame;
import org.joou.UInteger;

import javax.sound.midi.Soundbank;
import java.util.Random;

public class INVOKE_SPECIAL extends Index16Instruction{
    @Override
    public void Execute(Frame frame) {
        Class currentClass= frame.method.clazz;
        ConstantPool cp=currentClass.constantPool;
        MethodRef methodRef=(MethodRef)cp.getConstant(index).object;
        Class resolvedClass=methodRef.ResolvedClass();
        Method resolvedMethod=methodRef.ResolvedMethod();
        if(resolvedMethod.name.equals("<init>")&&resolvedMethod.clazz!=resolvedClass){
            System.out.println("java.lang.NoSuchMethodError");
        }
        if(resolvedMethod.IsStatic()){
            System.out.println("java.lang.IncompatibleClassChangeError");
        }
        Object ref=frame.operandStack.getRefFromTop
                (resolvedMethod.argSlotCount.subtract(1));
        if(ref==null){
            System.out.println("java.lang.NullPointerException at invoke");
        }
        if(resolvedMethod.IsProtected()&&
                (!resolvedMethod.clazz.getPackageName().equals(currentClass.getPackageName()))
                &&(!currentClass.isSubClassOf(resolvedMethod.clazz))
                &&(!ref.clazz.isSubClassOf(currentClass)||ref.clazz!=currentClass)){
            System.out.println("java.lang.IllegalAccessError-see todo");
        }//todo mark 此处逻辑与go不同

        Method methodToBeInvoked=resolvedMethod;
        if(currentClass.IsSuper()&&currentClass.isSubClassOf(resolvedClass)&&
                !resolvedMethod.name.equals("<init>")){
            methodToBeInvoked= Method_Lookup.LookupMethodInClass(currentClass.superClass,
                    methodRef.name,methodRef.descriptor);
        }
        if(methodToBeInvoked==null||methodToBeInvoked.IsAbstract()){
            System.out.println("java.lang.AbstractMethodError");
        }

        InvokeMethod.InvokeMethod(frame,methodToBeInvoked);
    }
}
