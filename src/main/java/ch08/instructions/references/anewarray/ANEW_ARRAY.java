package ch08.instructions.references.anewarray;

import ch08.instructions.base.instruction.Index16Instruction;
import ch08.rtda.Frame;
import ch08.rtda.OperandStack;
import ch08.rtda.heap.Class;
import ch08.rtda.heap.ClassRef;
import ch08.rtda.heap.Object;
import ch08.rtda.heap.constant_pool.ConstantPool;
import org.joou.UInteger;

public class ANEW_ARRAY extends Index16Instruction {
    @Override
    public void Execute(Frame frame) {
        ConstantPool cp=frame.method.clazz.constantPool;
        ClassRef classRef=(ClassRef)(cp.getConstant(index).object);
        Class componentClass=classRef.ResolvedClass();

        OperandStack stack=frame.operandStack;
        int count=stack.popInt();
        if(count<0){
            System.out.println("java.lang.NegativeArraySizeException");
        }
        Class arrClass=componentClass.arrayClass();
        Object arr=arrClass.newArray(UInteger.valueOf(count));
        stack.pushRef(arr);
    }
}
