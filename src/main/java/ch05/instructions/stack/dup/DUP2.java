package ch05.instructions.stack.dup;

import ch05.instructions.base.instruction.NoOperandsInstruction;
import ch05.rtda.Frame;
import ch05.rtda.Slot;

public class DUP2 extends NoOperandsInstruction {
    /*// Duplicate the top one or two operand stack values
    type DUP2 struct{ base.NoOperandsInstruction }

    *//*
    bottom -> top
    [...][c][b][a]____
              \____   |
                   |  |
                   V  V
    [...][c][b][a][b][a]
    *//*
    func (self *DUP2) Execute(frame *rtda.Frame) {
        stack := frame.OperandStack()
        slot1 := stack.PopSlot()
        slot2 := stack.PopSlot()
        stack.PushSlot(slot2)
        stack.PushSlot(slot1)
        stack.PushSlot(slot2)
        stack.PushSlot(slot1)
    }*/

    @Override
    public void Execute(Frame frame) {
        Slot slot1=frame.operandStack.popSlot();
        Slot slot2=frame.operandStack.popSlot();
        frame.operandStack.pushSlot(slot2);
        frame.operandStack.pushSlot(slot1);
        frame.operandStack.pushSlot(slot2);
        frame.operandStack.pushSlot(slot1);
    }
}
