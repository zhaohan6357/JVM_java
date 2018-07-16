package ch08.instructions.comparisons.dcmp;

import ch08.instructions.base.instruction.NoOperandsInstruction;
import ch08.instructions.comparisons.dcmp._DCMP;
import ch08.rtda.Frame;

public class DCMPL extends NoOperandsInstruction{
    @Override
    public void Execute(Frame frame) {
        _DCMP._dcmp(frame,false);
    }
}
