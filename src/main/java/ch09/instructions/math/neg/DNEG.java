package ch09.instructions.math.neg;

import ch09.instructions.base.instruction.NoOperandsInstruction;
import ch09.rtda.Frame;

public class DNEG extends NoOperandsInstruction {
    @Override
    public void Execute(Frame frame) {
        double val=frame.operandStack.popDouble();
        frame.operandStack.pushDouble(-val);
    }
}
