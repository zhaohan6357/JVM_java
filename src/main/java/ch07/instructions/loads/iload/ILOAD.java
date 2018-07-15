package ch07.instructions.loads.iload;

import ch07.instructions.loads.iload._ILOAD;
import ch07.rtda.Frame;
import ch07.instructions.base.instruction.Index8Instruction;

public class ILOAD extends Index8Instruction {
    // Load int from local variable
/*    type ILOAD struct{ base.Index8Instruction }

    func (self *ILOAD) Execute(frame *rtda.Frame) {
        _iload(frame, self.Index)
    }*/

    @Override
    public void Execute(Frame frame) {
        _ILOAD._ioad(frame,index);
    }
}
