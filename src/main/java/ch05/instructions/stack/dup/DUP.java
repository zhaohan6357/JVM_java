package ch05.instructions.stack.dup;

import ch05.instructions.base.instruction.NoOperandsInstruction;
import ch05.rtda.Frame;
import ch05.rtda.Slot;

public class DUP extends NoOperandsInstruction {

/*    // Duplicate the top operand stack value
    type DUP struct{ base.NoOperandsInstruction }

    *//*
    bottom -> top
    [...][c][b][a]
                 \_
                   |
                   V
    [...][c][b][a][a]
    *//*
    func (self *DUP) Execute(frame *rtda.Frame) {
        stack := frame.OperandStack()
        slot := stack.PopSlot()
        stack.PushSlot(slot)
        stack.PushSlot(slot)
    }*/

    @Override
    public void Execute(Frame frame) {
        Slot slot=frame.operandStack.popSlot();
        frame.operandStack.pushSlot(slot);
        frame.operandStack.pushSlot(slot);
    }
}
