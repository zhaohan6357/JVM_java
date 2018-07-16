package ch08.instructions.math.neg;

import ch08.instructions.base.instruction.NoOperandsInstruction;
import ch08.rtda.Frame;

public class LNEG extends NoOperandsInstruction{
    @Override
    public void Execute(Frame frame) {
        long val=frame.operandStack.popLong();
        frame.operandStack.pushDouble(-val);
    }
}
