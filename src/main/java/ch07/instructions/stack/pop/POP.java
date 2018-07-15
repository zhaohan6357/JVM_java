package ch07.instructions.stack.pop;

import ch07.instructions.base.instruction.NoOperandsInstruction;
import ch07.rtda.Frame;

public class POP extends NoOperandsInstruction {

/*    type POP struct{ base.NoOperandsInstruction }
    *//*
    bottom -> top
    [...][c][b][a]
                |
                V
    [...][c][b]
    *//*
    func (self *POP) Execute(frame *rtda.Frame) {
        stack := frame.OperandStack()
        stack.PopSlot()
    }*/

    @Override
    public void Execute(Frame frame) {
        frame.operandStack.popSlot();
    }
}


