package ch09.instructions.constants.const_;

import ch09.rtda.Frame;
import ch09.instructions.base.instruction.NoOperandsInstruction;

public class FCONST_0 extends NoOperandsInstruction{

    /*type FCONST_0 struct{ base.NoOperandsInstruction }

    func (self *FCONST_0) Execute(frame *rtda.Frame) {
        frame.OperandStack().PushFloat(0.0)
    }*/

    @Override
    public void Execute(Frame frame) {
        float f=0.0f;
        frame.operandStack.pushFloat(f);
    }
}
