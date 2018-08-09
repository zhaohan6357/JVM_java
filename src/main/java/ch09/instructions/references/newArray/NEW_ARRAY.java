package ch09.instructions.references.newArray;

import ch09.instructions.base.ByteCodeReader;
import ch09.instructions.base.instruction.Instruction;
import ch09.instructions.references.newArray.Atype;
import ch09.rtda.Frame;
import ch09.rtda.OperandStack;
import ch09.rtda.heap.Class;
import ch09.rtda.heap.ClassLoader;
import ch09.rtda.heap.Object;
import org.joou.UByte;
import org.joou.UInteger;

public class NEW_ARRAY extends Instruction {
    UByte atype;

    @Override
    public void FetchOperands(ByteCodeReader reader) {
        this.atype=reader.readUint8();
    }

    @Override
    public void Execute(Frame frame) {
        OperandStack stack=frame.operandStack;
        int count=stack.popInt();
        if(count<0){
            System.out.println("java.lang.NegativeArraySizeException");
        }
        ClassLoader classLoader=frame.method.clazz.loader;
        Class arrClass=getPrimitiveArrayClass(classLoader,this.atype);
        Object arr= arrClass.newArray(UInteger.valueOf(count));
        stack.pushRef(arr);
    }

    public static Class getPrimitiveArrayClass(ClassLoader loader,UByte atype){
        switch (atype.intValue()){
            case ch09.instructions.references.newArray.Atype.AT_BOOLEAN:
                return loader.loadClass("[Z");
            case ch09.instructions.references.newArray.Atype.AT_BYTE:
                return loader.loadClass("[B");
            case ch09.instructions.references.newArray.Atype.AT_CHAR:
                return loader.loadClass("[C");
            case ch09.instructions.references.newArray.Atype.AT_SHORT:
                return loader.loadClass("[S");
            case ch09.instructions.references.newArray.Atype.AT_INT:
                return loader.loadClass("[I");
            case ch09.instructions.references.newArray.Atype.AT_LONG:
                return loader.loadClass("[J");
            case ch09.instructions.references.newArray.Atype.AT_FLOAT:
                return loader.loadClass("[F");
            case Atype.AT_DOUBLE:
                return loader.loadClass("[D");
            default:
                System.out.println("Invalid atype!");
        }
            return null;
    }

}
