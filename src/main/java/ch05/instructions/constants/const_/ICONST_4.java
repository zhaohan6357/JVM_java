package ch05.instructions.constants.const_;

import ch05.rtda.Frame;
import ch05.instructions.base.instruction.NoOperandsInstruction;

public class ICONST_4 extends NoOperandsInstruction{
    @Override
    public void Execute(Frame frame) {
        frame.operandStack.pushInt(4);
    }
}
