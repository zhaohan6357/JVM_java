package ch08.instructions.control.return_;

import ch08.instructions.base.instruction.NoOperandsInstruction;
import ch08.rtda.Frame;

public class RETURN extends NoOperandsInstruction{
    @Override
    public void Execute(Frame frame) {
        frame.thread.popFrame();
    }
}
