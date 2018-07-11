package ch06.instructions.conversions.f2x;

import ch06.instructions.base.instruction.NoOperandsInstruction;
import ch06.rtda.Frame;

public class F2L extends NoOperandsInstruction{
    @Override
    public void Execute(Frame frame) {
        float f=frame.operandStack.popFloat();
        long d=(long)f;
        frame.operandStack.pushLong(d);
    }
}
