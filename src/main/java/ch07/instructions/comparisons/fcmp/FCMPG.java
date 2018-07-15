package ch07.instructions.comparisons.fcmp;

import ch07.instructions.base.instruction.NoOperandsInstruction;
import ch07.instructions.comparisons.fcmp._FCMP;
import ch07.rtda.Frame;

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
