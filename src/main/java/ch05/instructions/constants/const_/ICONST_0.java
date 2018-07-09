package ch05.instructions.constants.const_;

import ch05.rtda.Frame;
import ch05.instructions.base.instruction.NoOperandsInstruction;

public class ICONST_0 extends NoOperandsInstruction {
    /*type ICONST_0 struct{ base.NoOperandsInstruction }

    func (self *ICONST_0) Execute(frame *rtda.Frame) {
        frame.OperandStack().PushInt(0)
    }*/

    @Override
    public void Execute(Frame frame) {
        frame.operandStack.pushInt(0);
    }
}
