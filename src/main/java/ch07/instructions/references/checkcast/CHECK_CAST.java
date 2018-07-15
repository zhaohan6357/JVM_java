package ch07.instructions.references.checkcast;

import ch07.instructions.base.instruction.Index16Instruction;
import ch07.rtda.Frame;
import ch07.rtda.OperandStack;
import ch07.rtda.heap.Class;
import ch07.rtda.heap.ClassRef;
import ch07.rtda.heap.Object;
import ch07.rtda.heap.constant_pool.Constant;
import ch07.rtda.heap.constant_pool.ConstantPool;

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
