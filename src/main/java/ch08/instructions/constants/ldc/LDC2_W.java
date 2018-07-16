package ch08.instructions.constants.ldc;

import ch08.classfile.SourceFileAttribute;
import ch08.instructions.base.instruction.Index16Instruction;
import ch08.rtda.Frame;
import ch08.rtda.OperandStack;
import ch08.rtda.heap.constant_pool.Constant;
import ch08.rtda.heap.constant_pool.ConstantPool;

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
