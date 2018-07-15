package ch07.instructions.loads.dload;

import ch07.instructions.base.instruction.Index8Instruction;
import ch07.instructions.loads.dload._DLOAD;
import ch07.rtda.Frame;

public class DLOAD extends Index8Instruction {
    /*// Load double from local variable
    type DLOAD struct{ base.Index8Instruction }

    func (self *DLOAD) Execute(frame *rtda.Frame) {
        _dload(frame, self.Index)
    }*/

    @Override
    public void Execute(Frame frame) {
        _DLOAD._dload(frame,index);
    }
}
