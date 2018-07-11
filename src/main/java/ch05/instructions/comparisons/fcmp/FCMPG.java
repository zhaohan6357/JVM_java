package ch05.instructions.comparisons.fcmp;

import ch05.instructions.base.instruction.NoOperandsInstruction;
import ch05.rtda.Frame;

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
