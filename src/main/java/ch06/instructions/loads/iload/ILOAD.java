package ch06.instructions.loads.iload;

import ch06.instructions.loads.iload._ILOAD;
import ch06.rtda.Frame;
import ch06.instructions.base.instruction.Index8Instruction;

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
