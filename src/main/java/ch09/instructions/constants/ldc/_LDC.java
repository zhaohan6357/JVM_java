package ch09.instructions.constants.ldc;

import ch09.rtda.Frame;
import ch09.rtda.OperandStack;
import ch09.rtda.heap.Class;
import ch09.rtda.heap.ClassRef;
import ch09.rtda.heap.Object;
import ch09.rtda.heap.StringPool;
import ch09.rtda.heap.constant_pool.Constant;
import ch09.rtda.heap.constant_pool.ConstantPool;
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
        }else if(c.object.getClass()== ClassRef.class){
            ClassRef classRef=(ClassRef)(c.object);
            Object classObj=classRef.ResolvedClass().jClass;
            stack.pushRef(classObj);
        }
        //todo
    }
}
