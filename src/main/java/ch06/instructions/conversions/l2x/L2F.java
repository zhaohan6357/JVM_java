package ch06.instructions.conversions.l2x;

import ch06.instructions.base.instruction.NoOperandsInstruction;
import ch06.rtda.Frame;

public class L2F extends NoOperandsInstruction {
    @Override
    public void Execute(Frame frame) {
        long l = frame.operandStack.popLong();
        float d = (float) l;
        frame.operandStack.pushFloat(d);
    }
}
