package ch06.instructions.constants.const_;

import ch06.rtda.Frame;
import ch06.instructions.base.instruction.NoOperandsInstruction;

public class FCONST_2 extends NoOperandsInstruction{
    /*type FCONST_2 struct{ base.NoOperandsInstruction }

    func (self *FCONST_2) Execute(frame *rtda.Frame) {
        frame.OperandStack().PushFloat(2.0)
    }*/

    @Override
    public void Execute(Frame frame) {
        frame.operandStack.pushFloat(2.0f);
    }
}
