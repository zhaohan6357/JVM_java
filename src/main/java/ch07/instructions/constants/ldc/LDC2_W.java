package ch07.instructions.constants.ldc;

import ch07.classfile.SourceFileAttribute;
import ch07.instructions.base.instruction.Index16Instruction;
import ch07.rtda.Frame;
import ch07.rtda.OperandStack;
import ch07.rtda.heap.constant_pool.Constant;
import ch07.rtda.heap.constant_pool.ConstantPool;

public class LDC2_W extends Index16Instruction{
    @Override
    public void Execute(Frame frame) {
        OperandStack stack=frame.operandStack;
        ConstantPool cp=frame.method.clazz.constantPool;
        Constant c=cp.getConstant(index);
        if(c.object.getClass()==Long.class){
            stack.pushLong((long)c.object);
        }else if(c.object.getClass()==Double.class){
            stack.pushDouble((double)c.object);
        }else{
            System.out.println("java.lang.ClassFormatError");
        }
    }
}
