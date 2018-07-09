package ch05.instructions.constants.const_;

import ch05.instructions.base.instruction.NoOperandsInstruction;
import ch05.rtda.Frame;

public class ICONST_M1 extends NoOperandsInstruction{

  /*  func (self *ICONST_M1) Execute(frame *rtda.Frame) {
        frame.OperandStack().PushInt(-1)
    }*/

    @Override
    public void Execute(ch05.rtda.Frame frame) {
        int i=-1;
        frame.operandStack.pushInt(i);
    }
}
