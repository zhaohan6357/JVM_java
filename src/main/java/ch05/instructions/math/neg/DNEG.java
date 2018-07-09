package ch05.instructions.math.neg;

import ch05.instructions.base.instruction.NoOperandsInstruction;
import ch05.rtda.Frame;

public class DNEG extends NoOperandsInstruction {
    @Override
    public void Execute(Frame frame) {
        double val=frame.operandStack.popDouble();
        frame.operandStack.pushDouble(-val);
    }
}
