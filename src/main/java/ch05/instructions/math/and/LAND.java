package ch05.instructions.math.and;

import ch05.instructions.base.instruction.NoOperandsInstruction;
import ch05.rtda.Frame;

public class LAND extends NoOperandsInstruction{
    @Override
    public void Execute(Frame frame) {
        long v2=frame.operandStack.popLong();
        long v1=frame.operandStack.popLong();
        long result=v1&v2;
        frame.operandStack.pushLong(result);


    }
}
