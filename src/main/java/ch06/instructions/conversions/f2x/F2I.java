package ch06.instructions.conversions.f2x;

import ch06.instructions.base.instruction.NoOperandsInstruction;
import ch06.rtda.Frame;

public class F2I extends NoOperandsInstruction{
    @Override
    public void Execute(Frame frame) {
        float f=frame.operandStack.popFloat();
        int d=(int)f;
        frame.operandStack.pushInt(d);
    }
}
