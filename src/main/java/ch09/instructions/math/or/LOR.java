package ch09.instructions.math.or;

import ch09.instructions.base.instruction.NoOperandsInstruction;
import ch09.rtda.Frame;

public class LOR extends NoOperandsInstruction{
    @Override
    public void Execute(Frame frame) {
        long v2=frame.operandStack.popLong();
        long v1=frame.operandStack.popLong();
        long result=v1|v2;
        frame.operandStack.pushLong(result);


    }
}
