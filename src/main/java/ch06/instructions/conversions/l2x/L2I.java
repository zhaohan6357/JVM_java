package ch06.instructions.conversions.l2x;

import ch06.instructions.base.instruction.NoOperandsInstruction;
import ch06.rtda.Frame;

public class L2I extends NoOperandsInstruction {
    @Override
    public void Execute(Frame frame) {
        long l = frame.operandStack.popLong();
        int d = (int)l;
        frame.operandStack.pushInt(d);
    }
}
