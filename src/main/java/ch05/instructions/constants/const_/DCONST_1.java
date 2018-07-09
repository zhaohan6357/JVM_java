package ch05.instructions.constants.const_;

import ch05.rtda.Frame;
import ch05.instructions.base.instruction.NoOperandsInstruction;

public class DCONST_1 extends NoOperandsInstruction {
    /*type DCONST_1 struct{ base.NoOperandsInstruction }

    func (self *DCONST_1) Execute(frame *rtda.Frame) {
        frame.OperandStack().PushDouble(1.0)
    }*/

    @Override
    public void Execute(Frame frame) {
        double d = 1.0;
        frame.operandStack.pushDouble(d);
    }
}
