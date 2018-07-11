package ch06.instructions.math.neg;

import ch06.instructions.base.instruction.NoOperandsInstruction;
import ch06.rtda.Frame;

public class LNEG extends NoOperandsInstruction{
    @Override
    public void Execute(Frame frame) {
        long val=frame.operandStack.popLong();
        frame.operandStack.pushDouble(-val);
    }
}
