package ch09.instructions.math.neg;

import ch09.instructions.base.instruction.NoOperandsInstruction;
import ch09.rtda.Frame;

public class FNEG extends NoOperandsInstruction{

    @Override
    public void Execute(Frame frame) {
        float val=frame.operandStack.popFloat();
        frame.operandStack.pushDouble(-val);
    }
}


