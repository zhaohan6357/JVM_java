package ch06.instructions.conversions.l2x;

import ch06.instructions.base.instruction.NoOperandsInstruction;
import ch06.rtda.Frame;

public class L2D extends NoOperandsInstruction {
    @Override
    public void Execute(Frame frame) {
        long l = frame.operandStack.popLong();
        double d = (double)l;
        frame.operandStack.pushDouble(d);
    }
}
