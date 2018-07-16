package ch08.instructions.conversions.d2x;

import ch08.instructions.base.instruction.NoOperandsInstruction;
import ch08.rtda.Frame;

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
