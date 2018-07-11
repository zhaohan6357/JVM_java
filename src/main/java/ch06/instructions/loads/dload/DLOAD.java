package ch06.instructions.loads.dload;

import ch06.instructions.base.instruction.Index8Instruction;
import ch06.instructions.loads.dload._DLOAD;
import ch06.rtda.Frame;

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
