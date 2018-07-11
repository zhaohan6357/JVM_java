package ch05.instructions.comparisons.fcmp;

import ch05.instructions.base.instruction.NoOperandsInstruction;
import ch05.rtda.Frame;

public class FCMPL extends NoOperandsInstruction{
    @Override
    public void Execute(Frame frame) {
        _FCMP._fcmp(frame,false);
    }
}
