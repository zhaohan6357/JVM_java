package ch05.instructions.loads.fload;

import ch05.instructions.base.instruction.Index8Instruction;
import ch05.rtda.Frame;

public class FLOAD extends Index8Instruction {

/*
    type FLOAD struct{ base.Index8Instruction }

    func (self *FLOAD) Execute(frame *rtda.Frame) {
        _fload(frame, self.Index)
    }
*/

    @Override
    public void Execute(Frame frame) {
        _FLOAD._fload(frame,index);
    }
}
