package ch06.instructions.comparisons.fcmp;

import ch06.instructions.base.instruction.NoOperandsInstruction;
import ch06.instructions.comparisons.fcmp._FCMP;
import ch06.rtda.Frame;

public class FCMPL extends NoOperandsInstruction{
    @Override
    public void Execute(Frame frame) {
        _FCMP._fcmp(frame,false);
    }
}
