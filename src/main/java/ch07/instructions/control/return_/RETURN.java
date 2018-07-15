package ch07.instructions.control.return_;

import ch07.instructions.base.instruction.NoOperandsInstruction;
import ch07.rtda.Frame;

public class RETURN extends NoOperandsInstruction{
    @Override
    public void Execute(Frame frame) {
        frame.thread.popFrame();
    }
}
