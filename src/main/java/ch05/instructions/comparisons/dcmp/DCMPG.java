package ch05.instructions.comparisons.dcmp;

import ch05.instructions.base.instruction.NoOperandsInstruction;
import ch05.rtda.Frame;

public class DCMPG extends NoOperandsInstruction{
    @Override
    public void Execute(Frame frame) {
        _DCMP._dcmp(frame,true);
    }
}
