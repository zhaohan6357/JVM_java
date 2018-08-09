package ch09.instructions.control.return_;

import ch09.instructions.base.instruction.NoOperandsInstruction;
import ch09.rtda.Frame;

public class RETURN extends NoOperandsInstruction{
    @Override
    public void Execute(Frame frame) {
        frame.thread.popFrame();
    }
}
