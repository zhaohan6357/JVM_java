package ch09.instructions.stack.dup;

import ch09.instructions.base.instruction.NoOperandsInstruction;
import ch09.rtda.Frame;
import ch09.rtda.Slot;

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
        Slot slot1=new Slot(slot.num,slot.ref);
        frame.operandStack.pushSlot(slot);
        frame.operandStack.pushSlot(slot1);//todo mark
    }
}
