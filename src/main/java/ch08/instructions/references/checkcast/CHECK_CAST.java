package ch08.instructions.references.checkcast;

import ch08.instructions.base.instruction.Index16Instruction;
import ch08.rtda.Frame;
import ch08.rtda.OperandStack;
import ch08.rtda.heap.Class;
import ch08.rtda.heap.ClassRef;
import ch08.rtda.heap.Object;
import ch08.rtda.heap.constant_pool.Constant;
import ch08.rtda.heap.constant_pool.ConstantPool;

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
