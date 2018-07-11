package ch06.instructions.stack.pop;

import ch06.instructions.base.instruction.NoOperandsInstruction;
import ch06.rtda.Frame;

public class POP2 extends NoOperandsInstruction {
/*    // Pop the top one or two operand stack values
    type POP2 struct{ base.NoOperandsInstruction }

    *//*
    bottom -> top
    [...][c][b][a]
             |  |
             V  V
    [...][c]
    *//*
    func (self *POP2) Execute(frame *rtda.Frame) {
        stack := frame.OperandStack()
        stack.PopSlot()
        stack.PopSlot()
    }*/

    @Override
    public void Execute(Frame frame) {
        frame.operandStack.popSlot();
        frame.operandStack.popSlot();
    }
}
