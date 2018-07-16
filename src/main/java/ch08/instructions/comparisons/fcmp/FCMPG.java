package ch08.instructions.comparisons.fcmp;

import ch08.instructions.base.instruction.NoOperandsInstruction;
import ch08.instructions.comparisons.fcmp._FCMP;
import ch08.rtda.Frame;

public class FCMPG extends NoOperandsInstruction{
    /*type FCMPG struct{ base.NoOperandsInstruction }

    func (self *FCMPG) Execute(frame *rtda.Frame) {
        _fcmp(frame, true)
    }*/

    @Override
    public void Execute(Frame frame) {
        _FCMP._fcmp(frame,true);
    }
}
