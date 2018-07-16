package ch08.instructions.conversions.f2x;

import ch08.instructions.base.instruction.NoOperandsInstruction;
import ch08.rtda.Frame;

public class F2L extends NoOperandsInstruction{
    @Override
    public void Execute(Frame frame) {
        float f=frame.operandStack.popFloat();
        long d=(long)f;
        frame.operandStack.pushLong(d);
    }
}
