package ch08.instructions.comparisons.fcmp;

import ch08.instructions.base.instruction.NoOperandsInstruction;
import ch08.instructions.comparisons.fcmp._FCMP;
import ch08.rtda.Frame;

public class FCMPL extends NoOperandsInstruction{
    @Override
    public void Execute(Frame frame) {
        _FCMP._fcmp(frame,false);
    }
}
