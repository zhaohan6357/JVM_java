package ch06.instructions.constants.const_;

import ch06.rtda.Frame;
import ch06.instructions.base.instruction.NoOperandsInstruction;

public class ACONST_NULL extends NoOperandsInstruction {

/*    func (self *ACONST_NULL) Execute(frame *rtda.Frame) {
        frame.OperandStack().PushRef(nil)
    }*/

    @Override
    public void Execute(Frame frame) {
        frame.operandStack.pushRef(null);
    }

}
