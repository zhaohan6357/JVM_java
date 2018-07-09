package ch05.instructions.math.rem;

import ch05.instructions.base.instruction.NoOperandsInstruction;
import ch05.rtda.Frame;

public class DREM extends NoOperandsInstruction {
/*    type DREM struct{ base.NoOperandsInstruction }
    func (self *DREM) Execute(frame *rtda.Frame) {
        stack := frame.OperandStack()
        v2 := stack.PopDouble()
        v1 := stack.PopDouble()
        result := math.Mod(v1, v2)
        stack.PushDouble(result)
    }*/

    @Override
    public void Execute(Frame frame) {
        double v2=frame.operandStack.popDouble();
        double v1=frame.operandStack.popDouble();
        double result=v1%v2;
        frame.operandStack.pushDouble(result);
    }
}
