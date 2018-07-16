package ch08.instructions.math.neg;

import ch08.instructions.base.instruction.NoOperandsInstruction;
import ch08.rtda.Frame;

public class INEG extends NoOperandsInstruction {
    @Override
    public void Execute(Frame frame) {
        int val=frame.operandStack.popInt();
        frame.operandStack.pushDouble(-val);
    }
}
