package ch07.instructions.references.invokestatic;

import ch07.instructions.base.class_init_logic.InitClass;
import ch07.instructions.base.instruction.Index16Instruction;
import ch07.instructions.base.method_invoke_logic.InvokeMethod;
import ch07.rtda.Frame;
import ch07.rtda.heap.Class;
import ch07.rtda.heap.Method;
import ch07.rtda.heap.MethodRef;
import ch07.rtda.heap.constant_pool.ConstantPool;

public class INVOKE_STATIC extends Index16Instruction {
    @Override
    public void Execute(Frame frame) {
        ConstantPool cp = frame.method.clazz.constantPool;
        MethodRef methodRef = (MethodRef) cp.getConstant(index).object;
        Method resolvedMethod = methodRef.ResolvedMethod();
        if(!resolvedMethod.IsStatic()){
            System.out.println("java.lang.IncompatibleClassChangeError");
        }
        Class clazz=resolvedMethod.clazz;
        if(!clazz.initStarted){
            frame.revertNextPC();
            InitClass.InitClass(frame.thread,clazz);
            return;
        }
        InvokeMethod.InvokeMethod(frame,resolvedMethod);
    }
}
