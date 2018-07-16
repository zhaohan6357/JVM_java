package ch08.instructions.math.neg;

import ch08.instructions.base.instruction.NoOperandsInstruction;
import ch08.rtda.Frame;

public class DNEG extends NoOperandsInstruction {
    @Override
    public void Execute(Frame frame) {
        double val=frame.operandStack.popDouble();
        frame.operandStack.pushDouble(-val);
    }
}
