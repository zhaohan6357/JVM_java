package ch05.instructions.loads.aload;

import ch05.instructions.base.instruction.Index8Instruction;
import ch05.rtda.Frame;

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
