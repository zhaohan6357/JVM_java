package ch08.instructions.references.invokeinterface;

import ch08.instructions.base.ByteCodeReader;
import ch08.instructions.base.instruction.Instruction;
import ch08.instructions.base.method_invoke_logic.InvokeMethod;
import ch08.rtda.Frame;
import ch08.rtda.heap.Class;
import ch08.rtda.heap.*;
import ch08.rtda.heap.Object;
import ch08.rtda.heap.constant_pool.ConstantPool;
import org.joou.UInteger;

public class INVOKE_INTERFACE extends Instruction{
    //UInteger count;
    //UInteger zero;

    @Override
    public void FetchOperands(ByteCodeReader reader) {
        int i=reader.readUInt16().intValue();
        index=UInteger.valueOf(i);
        reader.readUint8();//count
        reader.readUint8();//must be 0
    }

    @Override
    public void Execute(Frame frame) {
        Class currentClass= frame.method.clazz;
        ConstantPool cp=currentClass.constantPool;
        InterfaceMethodRef methodRef=(InterfaceMethodRef)cp.getConstant(index).object;

        Class resolvedClass=methodRef.ResolvedClass();

        Method resolvedMethod=methodRef.ResolvedInterfaceMethod();
        if(resolvedMethod.IsStatic()||resolvedMethod.IsPrivate()){
            System.out.println("java.lang.IncompatibleClassChangeError");
        }
        Object ref=frame.operandStack.getRefFromTop
                (resolvedMethod.argSlotCount.subtract(1));
        if(ref==null){
            System.out.println("java.lang.NullPointerException");
        }

        if(!ref.clazz.isImplements(methodRef.ResolvedClass())){
            System.out.println("java.lang.IncompatibleClassChangeError");
        }
        Method methodToBeInvoked= Method_Lookup.LookupMethodInClass(ref.clazz,
                methodRef.name,methodRef.descriptor);
        if(methodToBeInvoked==null||methodToBeInvoked.IsAbstract()){
            System.out.println("java.lang.AbstractMethodError");
        }
        if(!methodToBeInvoked.IsPublic()){
            System.out.println("java.lang.IllegalAccessError");
        }
        InvokeMethod.InvokeMethod(frame,methodToBeInvoked);
    }
}
