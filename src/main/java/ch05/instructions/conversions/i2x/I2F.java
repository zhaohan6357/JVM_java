package ch05.instructions.conversions.i2x;

import ch05.instructions.base.instruction.NoOperandsInstruction;
import ch05.rtda.Frame;

public class I2F extends NoOperandsInstruction {
    @Override
    public void Execute(Frame frame) {
        int i = frame.operandStack.popInt();
        float v = (float) i;
        frame.operandStack.pushFloat(v);
    }
}
