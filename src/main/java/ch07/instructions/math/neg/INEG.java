package ch07.instructions.math.neg;

import ch07.instructions.base.instruction.NoOperandsInstruction;
import ch07.rtda.Frame;

public class INEG extends NoOperandsInstruction {
    @Override
    public void Execute(Frame frame) {
        int val=frame.operandStack.popInt();
        frame.operandStack.pushDouble(-val);
    }
}
