package ch09.instructions.references.instanceof_;

import ch09.instructions.base.instruction.Index16Instruction;
import ch09.rtda.Frame;
import ch09.rtda.OperandStack;
import ch09.rtda.heap.Class;
import ch09.rtda.heap.ClassRef;
import ch09.rtda.heap.Object;
import ch09.rtda.heap.constant_pool.ConstantPool;

public class INSTANCE_OF extends Index16Instruction {
    @Override
    public void Execute(Frame frame) {
        OperandStack stack=frame.operandStack;
        Object ref=stack.popRef();
        if(ref==null){
            stack.pushInt(0);
            return;
        }
        ConstantPool cp=frame.method.clazz.constantPool;
        ClassRef classRef=(ClassRef)cp.getConstant(index).object;
        Class clazz=classRef.ResolvedClass();
        if(ref.isInstanceOf(clazz)){
            stack.pushInt(1);
        }else{
            stack.pushInt(0);
        }
    }
}
