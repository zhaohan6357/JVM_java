package ch06.instructions.math.neg;

import ch06.instructions.base.instruction.NoOperandsInstruction;
import ch06.rtda.Frame;

public class INEG extends NoOperandsInstruction {
    @Override
    public void Execute(Frame frame) {
        int val=frame.operandStack.popInt();
        frame.operandStack.pushDouble(-val);
    }
}
