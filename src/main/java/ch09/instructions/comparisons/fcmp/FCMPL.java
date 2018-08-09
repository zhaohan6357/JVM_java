package ch09.instructions.comparisons.fcmp;

import ch09.instructions.base.instruction.NoOperandsInstruction;
import ch09.instructions.comparisons.fcmp._FCMP;
import ch09.rtda.Frame;

public class FCMPL extends NoOperandsInstruction{
    @Override
    public void Execute(Frame frame) {
        _FCMP._fcmp(frame,false);
    }
}
