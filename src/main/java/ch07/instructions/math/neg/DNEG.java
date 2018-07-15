package ch07.instructions.math.neg;

import ch07.instructions.base.instruction.NoOperandsInstruction;
import ch07.rtda.Frame;

public class DNEG extends NoOperandsInstruction {
    @Override
    public void Execute(Frame frame) {
        double val=frame.operandStack.popDouble();
        frame.operandStack.pushDouble(-val);
    }
}
