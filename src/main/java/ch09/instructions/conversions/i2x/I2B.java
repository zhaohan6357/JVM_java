package ch09.instructions.conversions.i2x;

import ch09.instructions.base.instruction.NoOperandsInstruction;
import ch09.rtda.Frame;

public class I2B extends NoOperandsInstruction {
    @Override
    public void Execute(Frame frame) {
        int i = frame.operandStack.popInt();
        int v = (int) ((byte) i);
        frame.operandStack.pushInt(v);
    }
}
