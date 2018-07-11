package ch05.instructions.conversions.d2x;

import ch05.instructions.base.instruction.NoOperandsInstruction;
import ch05.rtda.Frame;

public class D2F extends NoOperandsInstruction {
/*    // Convert double to float
    type D2F struct{ base.NoOperandsInstruction }

    func (self *D2F) Execute(frame *rtda.Frame) {
        stack := frame.OperandStack()
        d := stack.PopDouble()
        f := float32(d)
        stack.PushFloat(f)
    }*/

    @Override
    public void Execute(Frame frame) {
        double d = frame.operandStack.popDouble();
        float f = (float) d;
        frame.operandStack.pushFloat(f);
    }
}
