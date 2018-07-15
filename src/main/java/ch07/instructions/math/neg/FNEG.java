package ch07.instructions.math.neg;

import ch07.instructions.base.instruction.NoOperandsInstruction;
import ch07.rtda.Frame;

public class FNEG extends NoOperandsInstruction{

    @Override
    public void Execute(Frame frame) {
        float val=frame.operandStack.popFloat();
        frame.operandStack.pushDouble(-val);
    }
}


