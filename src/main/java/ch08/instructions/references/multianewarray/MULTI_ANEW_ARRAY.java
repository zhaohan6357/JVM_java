package ch08.instructions.references.multianewarray;

import ch08.JVMUtils;
import ch08.instructions.base.ByteCodeReader;
import ch08.instructions.base.instruction.Instruction;
import ch08.rtda.Frame;
import ch08.rtda.OperandStack;
import ch08.rtda.heap.Class;
import ch08.rtda.heap.ClassRef;
import ch08.rtda.heap.Object;
import ch08.rtda.heap.constant_pool.ConstantPool;
import org.joou.UByte;
import org.joou.UInteger;
import org.joou.UShort;

public class MULTI_ANEW_ARRAY extends Instruction{
    UShort index;
    UByte dimensions;

    @Override
    public void FetchOperands(ByteCodeReader reader) {
        this.index=reader.readUInt16();
        this.dimensions=reader.readUint8();
    }

    @Override
    public void Execute(Frame frame) {
        ConstantPool cp=frame.method.clazz.constantPool;
        ClassRef classRef=(ClassRef)(cp.getConstant(UInteger.valueOf(this.index.intValue())).object);
        Class arrClass=classRef.ResolvedClass();
        OperandStack stack=frame.operandStack;
        int[] counts=popAndCheckCounts(stack,this.dimensions.intValue());
        Object arr=newMultiDimensionalArray(counts,arrClass);
        stack.pushRef(arr);
    }

    public static int[] popAndCheckCounts(OperandStack stack,int dimensions){
        int[] counts=new int[dimensions];
        for(int i=dimensions-1;i>=0;i--){
            counts[i]=stack.popInt();
            if(counts[i]<0){
                System.out.println("java.lang.NegativeArraySizeException");
                System.exit(1);
            }
        }
        return counts;
    }
    public static Object newMultiDimensionalArray(int[] counts, Class arrClass){
        UInteger count=UInteger.valueOf(counts[0]);
        Object arr=arrClass.newArray(count);
        if(counts.length>1){
            Object[] refs=arr.Refs();
            for(int i=0;i<refs.length;i++){
                refs[i]=newMultiDimensionalArray(JVMUtils.intArraySub(counts,1),arrClass);
            }
        }
        return arr;
    }
}
