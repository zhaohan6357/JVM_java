package ch08.instructions.loads.fload;

import ch08.instructions.base.instruction.Index8Instruction;
import ch08.instructions.loads.fload._FLOAD;
import ch08.rtda.Frame;

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
