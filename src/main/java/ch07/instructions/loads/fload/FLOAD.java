package ch07.instructions.loads.fload;

import ch07.instructions.base.instruction.Index8Instruction;
import ch07.instructions.loads.fload._FLOAD;
import ch07.rtda.Frame;

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
