package ch09.instructions.math.neg;

import ch09.instructions.base.instruction.NoOperandsInstruction;
import ch09.rtda.Frame;

public class INEG extends NoOperandsInstruction {
    @Override
    public void Execute(Frame frame) {
        int val=frame.operandStack.popInt();
        frame.operandStack.pushDouble(-val);
    }
}
