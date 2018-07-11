package ch06.instructions.conversions.i2x;

import ch06.instructions.base.instruction.NoOperandsInstruction;
import ch06.rtda.Frame;

public class I2B extends NoOperandsInstruction {
    @Override
    public void Execute(Frame frame) {
        int i = frame.operandStack.popInt();
        int v = (int) ((byte) i);
        frame.operandStack.pushInt(v);
    }
}
