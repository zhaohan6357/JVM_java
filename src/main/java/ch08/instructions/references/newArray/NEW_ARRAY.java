package ch08.instructions.references.newArray;

import ch08.instructions.base.ByteCodeReader;
import ch08.instructions.base.instruction.Instruction;
import ch08.rtda.Frame;
import ch08.rtda.OperandStack;
import ch08.rtda.heap.Class;
import ch08.rtda.heap.ClassLoader;
import ch08.rtda.heap.Object;
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
            case Atype.AT_BOOLEAN:
                return loader.loadClass("[Z");
            case Atype.AT_BYTE:
                return loader.loadClass("[B");
            case Atype.AT_CHAR:
                return loader.loadClass("[C");
            case Atype.AT_SHORT:
                return loader.loadClass("[S");
            case Atype.AT_INT:
                return loader.loadClass("[I");
            case Atype.AT_LONG:
                return loader.loadClass("[J");
            case Atype.AT_FLOAT:
                return loader.loadClass("[F");
            case Atype.AT_DOUBLE:
                return loader.loadClass("[D");
            default:
                System.out.println("Invalid atype!");
        }
            return null;
    }

}
