package ch08.instructions.conversions.i2x;

import ch08.instructions.base.instruction.NoOperandsInstruction;
import ch08.rtda.Frame;

public class I2C extends NoOperandsInstruction {
    @Override
    public void Execute(Frame frame) {
        int i = frame.operandStack.popInt();
        int v = (int) ((char) i);
        frame.operandStack.pushInt(v);
    }
}
