package ch09.instructions.comparisons.dcmp;

import ch09.instructions.base.instruction.NoOperandsInstruction;
import ch09.instructions.comparisons.dcmp._DCMP;
import ch09.rtda.Frame;

public class DCMPL extends NoOperandsInstruction{
    @Override
    public void Execute(Frame frame) {
        _DCMP._dcmp(frame,false);
    }
}
