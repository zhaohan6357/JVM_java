package ch09.instructions.constants.const_;

import ch09.rtda.Frame;
import ch09.instructions.base.instruction.NoOperandsInstruction;

public class LCONST_0 extends NoOperandsInstruction{
    @Override
    public void Execute(Frame frame) {
        frame.operandStack.pushLong(0L);
    }
}
