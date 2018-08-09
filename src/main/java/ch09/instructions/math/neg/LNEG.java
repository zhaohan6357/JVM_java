package ch09.instructions.math.neg;

import ch09.instructions.base.instruction.NoOperandsInstruction;
import ch09.rtda.Frame;

public class LNEG extends NoOperandsInstruction{
    @Override
    public void Execute(Frame frame) {
        long val=frame.operandStack.popLong();
        frame.operandStack.pushDouble(-val);
    }
}
