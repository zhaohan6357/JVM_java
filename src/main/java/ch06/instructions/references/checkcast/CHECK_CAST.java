package ch06.instructions.references.checkcast;

import ch06.instructions.base.instruction.Index16Instruction;
import ch06.rtda.Frame;
import ch06.rtda.OperandStack;
import ch06.rtda.heap.Class;
import ch06.rtda.heap.ClassRef;
import ch06.rtda.heap.Object;
import ch06.rtda.heap.constant_pool.Constant;
import ch06.rtda.heap.constant_pool.ConstantPool;

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
