package ch05.instructions.math.neg;

import ch05.instructions.base.instruction.NoOperandsInstruction;
import ch05.rtda.Frame;

public class LNEG extends NoOperandsInstruction{
    @Override
    public void Execute(Frame frame) {
        long val=frame.operandStack.popLong();
        frame.operandStack.pushDouble(-val);
    }
}
