package ch07.instructions.conversions.f2x;

import ch07.instructions.base.instruction.NoOperandsInstruction;
import ch07.rtda.Frame;

public class F2D extends NoOperandsInstruction{
    @Override
    public void Execute(Frame frame) {
        float f=frame.operandStack.popFloat();
        double d=(double)f;
        frame.operandStack.pushDouble(d);
    }
}
