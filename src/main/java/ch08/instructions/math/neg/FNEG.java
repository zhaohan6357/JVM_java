package ch08.instructions.math.neg;

import ch08.instructions.base.instruction.NoOperandsInstruction;
import ch08.rtda.Frame;

public class FNEG extends NoOperandsInstruction{

    @Override
    public void Execute(Frame frame) {
        float val=frame.operandStack.popFloat();
        frame.operandStack.pushDouble(-val);
    }
}


