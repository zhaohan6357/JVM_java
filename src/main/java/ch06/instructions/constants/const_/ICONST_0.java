package ch06.instructions.constants.const_;

import ch06.rtda.Frame;
import ch06.instructions.base.instruction.NoOperandsInstruction;

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
