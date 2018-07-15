package ch07.instructions.loads.aload;

import ch07.instructions.base.instruction.Index8Instruction;
import ch07.instructions.loads.aload._ALOAD;
import ch07.rtda.Frame;

public class ALOAD extends Index8Instruction {
    /*type ALOAD struct{ base.Index8Instruction }

    func (self *ALOAD) Execute(frame *rtda.Frame) {
        _aload(frame, self.Index)
    }*/

    @Override
    public void Execute(Frame frame) {
        _ALOAD._aload(frame,index);
    }
}
