package ch09.instructions.constants.const_;

import ch09.instructions.base.instruction.NoOperandsInstruction;
import ch09.rtda.Frame;

public class ICONST_M1 extends NoOperandsInstruction{

  /*  func (self *ICONST_M1) Execute(frame *rtda.Frame) {
        frame.OperandStack().PushInt(-1)
    }*/

    @Override
    public void Execute(Frame frame) {
        int i=-1;
        frame.operandStack.pushInt(i);
    }
}
