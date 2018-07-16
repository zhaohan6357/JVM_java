package ch08.instructions.constants.ldc;

import ch08.rtda.Frame;
import ch08.rtda.OperandStack;
import ch08.rtda.heap.Class;
import ch08.rtda.heap.Object;
import ch08.rtda.heap.StringPool;
import ch08.rtda.heap.constant_pool.Constant;
import ch08.rtda.heap.constant_pool.ConstantPool;
import org.joou.UInteger;

public class _LDC {
    public static void _ldc(Frame frame, UInteger index){
        OperandStack stack=frame.operandStack;
        Class clazz=frame.method.clazz;
        ConstantPool cp=frame.method.clazz.constantPool;
        Constant c=cp.getConstant(index);
        if(c.object.getClass()==Integer.class){
            stack.pushInt((int)c.object);
        }else if(c.object.getClass()==Float.class){
            stack.pushFloat((float)c.object);
        }else if(c.object.getClass()==String.class){
            Object internedStr= StringPool.JString(clazz.loader,(String)c.object);
            stack.pushRef(internedStr);
        }
        //todo
    }
}
