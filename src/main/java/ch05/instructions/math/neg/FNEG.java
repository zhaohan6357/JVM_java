package ch05.instructions.math.neg;

import ch05.instructions.base.instruction.NoOperandsInstruction;
import ch05.rtda.Frame;

public class FNEG extends NoOperandsInstruction{

    @Override
    public void Execute(Frame frame) {
        float val=frame.operandStack.popFloat();
        frame.operandStack.pushDouble(-val);
    }
}


