package ch06.instructions.constants.const_;

import ch06.rtda.Frame;
import ch06.instructions.base.instruction.NoOperandsInstruction;

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
