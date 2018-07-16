package ch08.instructions.references.instanceof_;

import ch08.instructions.base.instruction.Index16Instruction;
import ch08.rtda.Frame;
import ch08.rtda.OperandStack;
import ch08.rtda.heap.Class;
import ch08.rtda.heap.ClassRef;
import ch08.rtda.heap.Object;
import ch08.rtda.heap.constant_pool.ConstantPool;

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
