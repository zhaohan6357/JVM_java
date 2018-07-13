package ch06.instructions.constants.ldc;

import ch06.rtda.Frame;
import ch06.rtda.OperandStack;
import ch06.rtda.heap.constant_pool.Constant;
import ch06.rtda.heap.constant_pool.ConstantPool;
import org.joou.UInteger;

public class _LDC {
    public static void _ldc(Frame frame, UInteger index){
        OperandStack stack=frame.operandStack;
        ConstantPool cp=frame.method.clazz.constantPool;
        Constant c=cp.getConstant(index);
        if(c.object.getClass()==Integer.class){
            stack.pushInt((int)c.object);
        }else if(c.object.getClass()==Float.class){
            stack.pushFloat((float)c.object);
        }
        //todo

    }
}
