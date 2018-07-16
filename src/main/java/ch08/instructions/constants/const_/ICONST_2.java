package ch08.instructions.constants.const_;

import ch08.rtda.Frame;
import ch08.instructions.base.instruction.NoOperandsInstruction;

public class ICONST_2 extends NoOperandsInstruction {
    @Override
    public void Execute(Frame frame) {
        frame.operandStack.pushInt(2);
    }
}
