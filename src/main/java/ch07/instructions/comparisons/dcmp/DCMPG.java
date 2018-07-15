package ch07.instructions.comparisons.dcmp;

import ch07.instructions.base.instruction.NoOperandsInstruction;
import ch07.instructions.comparisons.dcmp._DCMP;
import ch07.rtda.Frame;

public class DCMPG extends NoOperandsInstruction{
    @Override
    public void Execute(Frame frame) {
        _DCMP._dcmp(frame,true);
    }
}
