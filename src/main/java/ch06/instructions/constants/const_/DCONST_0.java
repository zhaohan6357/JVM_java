package ch06.instructions.constants.const_;

import ch06.rtda.Frame;
import ch06.instructions.base.instruction.NoOperandsInstruction;


public class DCONST_0 extends NoOperandsInstruction {
    /*func (self *DCONST_0) Execute(frame *rtda.Frame) {
        frame.OperandStack().PushDouble(0.0)
    }*/

    @Override
    public void Execute(Frame frame) {
        double d=0.0;
        frame.operandStack.pushDouble(d);
    }
}
