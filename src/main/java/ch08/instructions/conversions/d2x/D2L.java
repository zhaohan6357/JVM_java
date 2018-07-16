package ch08.instructions.conversions.d2x;

import ch08.instructions.base.instruction.NoOperandsInstruction;
import ch08.rtda.Frame;

public class D2L extends NoOperandsInstruction{
    @Override
    public void Execute(Frame frame) {
        double d = frame.operandStack.popDouble();
        long i=(long)d;
        frame.operandStack.pushLong(i);
    }
}
