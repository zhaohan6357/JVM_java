package ch09.instructions.conversions.i2x;

import ch09.instructions.base.instruction.NoOperandsInstruction;
import ch09.rtda.Frame;

public class I2L extends NoOperandsInstruction {
    @Override
    public void Execute(Frame frame) {
        int i = frame.operandStack.popInt();
        long v = (long)i;
        frame.operandStack.pushLong(v);
    }
}
