package ch05.instructions.math.neg;

import ch05.instructions.base.instruction.NoOperandsInstruction;
import ch05.rtda.Frame;

public class INEG extends NoOperandsInstruction {
    @Override
    public void Execute(Frame frame) {
        int val=frame.operandStack.popInt();
        frame.operandStack.pushDouble(-val);
    }
}
