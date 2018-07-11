package ch06.instructions.comparisons.dcmp;

import ch06.instructions.base.instruction.NoOperandsInstruction;
import ch06.instructions.comparisons.dcmp._DCMP;
import ch06.rtda.Frame;

public class DCMPG extends NoOperandsInstruction{
    @Override
    public void Execute(Frame frame) {
        _DCMP._dcmp(frame,true);
    }
}
