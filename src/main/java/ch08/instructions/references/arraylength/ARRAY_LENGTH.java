package ch08.instructions.references.arraylength;

import ch08.instructions.base.instruction.NoOperandsInstruction;
import ch08.rtda.Frame;
import ch08.rtda.OperandStack;
import ch08.rtda.heap.Object;

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
