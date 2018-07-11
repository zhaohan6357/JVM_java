package ch05.instructions.conversions.d2x;

import ch05.instructions.base.instruction.NoOperandsInstruction;
import ch05.rtda.Frame;

public class D2I extends NoOperandsInstruction {
    @Override
    public void Execute(Frame frame) {
        double d = frame.operandStack.popDouble();
        int i=(int)d;
        frame.operandStack.pushInt(i);
    }
}
