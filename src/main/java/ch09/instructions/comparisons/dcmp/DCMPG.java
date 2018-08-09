package ch09.instructions.comparisons.dcmp;

import ch09.instructions.base.instruction.NoOperandsInstruction;
import ch09.instructions.comparisons.dcmp._DCMP;
import ch09.rtda.Frame;

public class DCMPG extends NoOperandsInstruction{
    @Override
    public void Execute(Frame frame) {
        _DCMP._dcmp(frame,true);
    }
}
