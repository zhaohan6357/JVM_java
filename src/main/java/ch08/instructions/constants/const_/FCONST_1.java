package ch08.instructions.constants.const_;

import ch08.rtda.Frame;
import ch08.instructions.base.instruction.NoOperandsInstruction;

public class FCONST_1 extends NoOperandsInstruction{
    /*type FCONST_1 struct{ base.NoOperandsInstruction }

    func (self *FCONST_1) Execute(frame *rtda.Frame) {
        frame.OperandStack().PushFloat(1.0)
    }*/

    @Override
    public void Execute(Frame frame) {
        frame.operandStack.pushFloat(1.0f);
    }
}
