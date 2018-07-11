package ch06.instructions.math.neg;

import ch06.instructions.base.instruction.NoOperandsInstruction;
import ch06.rtda.Frame;

public class FNEG extends NoOperandsInstruction{

    @Override
    public void Execute(Frame frame) {
        float val=frame.operandStack.popFloat();
        frame.operandStack.pushDouble(-val);
    }
}


