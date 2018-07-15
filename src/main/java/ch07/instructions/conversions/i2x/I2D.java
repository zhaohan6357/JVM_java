package ch07.instructions.conversions.i2x;

import ch07.instructions.base.instruction.NoOperandsInstruction;
import ch07.rtda.Frame;

public class I2D extends NoOperandsInstruction {
    @Override
    public void Execute(Frame frame) {
        int i = frame.operandStack.popInt();
        double v = (double) i;
        frame.operandStack.pushDouble(v);
    }
}
