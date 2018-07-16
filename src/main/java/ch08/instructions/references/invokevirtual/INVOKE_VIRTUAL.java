package ch08.instructions.references.invokevirtual;

import ch08.instructions.base.instruction.Index16Instruction;
import ch08.instructions.base.method_invoke_logic.InvokeMethod;
import ch08.rtda.Frame;
import ch08.rtda.OperandStack;
import ch08.rtda.heap.*;
import ch08.rtda.heap.Class;
import ch08.rtda.heap.Object;
import ch08.rtda.heap.constant_pool.ConstantPool;

public class INVOKE_VIRTUAL extends Index16Instruction {

    @Override
    public void Execute(Frame frame) {
        Class currentClass=frame.method.clazz;
        ConstantPool cp=currentClass.constantPool;
        MethodRef methodRef=(MethodRef)cp.getConstant(index).object;
        Class resolvedClass=methodRef.ResolvedClass();
        Method resolvedMethod=methodRef.ResolvedMethod();
        if(resolvedMethod.IsStatic()){
            System.out.println("java.lang.IncompatibleClassChangeError");
        }

        Object ref=frame.operandStack.getRefFromTop
                (resolvedMethod.argSlotCount.subtract(1));
        if(ref==null){
            if(methodRef.name.equals("println")){
                _println(frame.operandStack,methodRef.descriptor);
                return;
            }
            System.out.println("java.lang.NullPointerException");
        }
        if(resolvedMethod.IsProtected()&&
                (!resolvedMethod.clazz.getPackageName().equals(currentClass.getPackageName()))
                &&(!currentClass.isSubClassOf(resolvedMethod.clazz))
                &&(!ref.clazz.isSubClassOf(currentClass)||ref.clazz!=currentClass)){
            System.out.println("java.lang.IllegalAccessError-see todo");
        }//todo mark 此处逻辑与go不同

        Method methodToBeInvoked= Method_Lookup.LookupMethodInClass(ref.clazz,
                methodRef.name,methodRef.descriptor);
        if(methodToBeInvoked==null||methodToBeInvoked.IsAbstract()){
            System.out.println("java.lang.AbstractMethodError");
        }
        InvokeMethod.InvokeMethod(frame,methodToBeInvoked);

    }

    public static  void _println(OperandStack stack,String descriptor){
        switch (descriptor){
            case "(Z)V":
                System.out.println(stack.popInt() != 0);
                break;
            case "(C)V":
                System.out.println(stack.popInt());
                break;
            case "(I)V": case "(B)V":case "(S)V":
                System.out.println(stack.popInt());
                break;
            case "(F)V":
                System.out.println(stack.popFloat());
                break;
            case "(J)V":
                System.out.println(stack.popLong());
                break;
            case "(D)V":
                System.out.println(stack.popDouble());
                break;
            case "(Ljava/lang/String;)V":
                Object jStr=stack.popRef();
                String str=StringPool.getString(jStr);
                System.out.println(str);
                break;
            default:
                System.out.println("println: " +descriptor);
        }
        stack.popRef();
    }
}
