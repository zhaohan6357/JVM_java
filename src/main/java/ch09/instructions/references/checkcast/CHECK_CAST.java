package ch09.instructions.references.checkcast;

import ch09.instructions.base.instruction.Index16Instruction;
import ch09.rtda.Frame;
import ch09.rtda.OperandStack;
import ch09.rtda.heap.Class;
import ch09.rtda.heap.ClassRef;
import ch09.rtda.heap.Object;
import ch09.rtda.heap.constant_pool.Constant;
import ch09.rtda.heap.constant_pool.ConstantPool;

public class CHECK_CAST extends Index16Instruction {
    @Override
    public void Execute(Frame frame) {
        OperandStack stack=frame.operandStack;
        Object ref=stack.popRef();
        stack.pushRef(ref);
        if(ref==null){
            return;
        }
        ConstantPool cp=frame.method.clazz.constantPool;
        ClassRef classRef=(ClassRef)cp.getConstant(this.index).object;
        Class clazz=classRef.ResolvedClass();
        if(!ref.isInstanceOf(clazz)){
            System.out.println("java.lang.ClassCastException");
            return;
        }
    }
}
