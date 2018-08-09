package ch09.instructions.references.arraylength;

import ch09.instructions.base.instruction.NoOperandsInstruction;
import ch09.rtda.Frame;
import ch09.rtda.OperandStack;
import ch09.rtda.heap.Object;

public class ARRAY_LENGTH extends NoOperandsInstruction {
    @Override
    public void Execute(Frame frame) {
        OperandStack stack=frame.operandStack;
        Object arrRef=stack.popRef();
        if(arrRef==null){
            System.out.println("java.lang.NullPointerException at ARRAY_LENGTH");
        }
        int arrlen=arrRef.arrayLength();
        stack.pushInt(arrlen);
    }
}
