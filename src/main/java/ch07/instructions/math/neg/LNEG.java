package ch07.instructions.math.neg;

import ch07.instructions.base.instruction.NoOperandsInstruction;
import ch07.rtda.Frame;

public class LNEG extends NoOperandsInstruction{
    @Override
    public void Execute(Frame frame) {
        long val=frame.operandStack.popLong();
        frame.operandStack.pushDouble(-val);
    }
}
