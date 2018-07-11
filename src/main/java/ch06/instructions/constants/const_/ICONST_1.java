package ch06.instructions.constants.const_;

import ch06.rtda.Frame;
import ch06.instructions.base.instruction.NoOperandsInstruction;

public class ICONST_1 extends NoOperandsInstruction{
    @Override
    public void Execute(Frame frame) {
        frame.operandStack.pushInt(1);
    }
}
