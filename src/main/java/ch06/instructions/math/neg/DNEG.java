package ch06.instructions.math.neg;

import ch06.instructions.base.instruction.NoOperandsInstruction;
import ch06.rtda.Frame;

public class DNEG extends NoOperandsInstruction {
    @Override
    public void Execute(Frame frame) {
        double val=frame.operandStack.popDouble();
        frame.operandStack.pushDouble(-val);
    }
}
