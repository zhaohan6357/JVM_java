package ch07.instructions.constants.const_;

import ch07.rtda.Frame;
import ch07.instructions.base.instruction.NoOperandsInstruction;

public class LCONST_1 extends NoOperandsInstruction{
    @Override
    public void Execute(Frame frame) {
        frame.operandStack.pushLong(1L);
    }
}
