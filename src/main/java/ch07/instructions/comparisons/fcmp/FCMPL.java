package ch07.instructions.comparisons.fcmp;

import ch07.instructions.base.instruction.NoOperandsInstruction;
import ch07.instructions.comparisons.fcmp._FCMP;
import ch07.rtda.Frame;

public class FCMPL extends NoOperandsInstruction{
    @Override
    public void Execute(Frame frame) {
        _FCMP._fcmp(frame,false);
    }
}
