package ch05.instructions.stack.dup;

import ch05.instructions.base.instruction.NoOperandsInstruction;
import ch05.rtda.Frame;
import ch05.rtda.Slot;

public class DUP_X2 extends NoOperandsInstruction {
    /*// Duplicate the top operand stack value and insert two or three values down
    type DUP_X2 struct{ base.NoOperandsInstruction }

    *//*
    bottom -> top
    [...][c][b][a]
           _____/
          |
          V
    [...][a][c][b][a]
    *//*
    func (self *DUP_X2) Execute(frame *rtda.Frame) {
        stack := frame.OperandStack()
        slot1 := stack.PopSlot()
        slot2 := stack.PopSlot()
        slot3 := stack.PopSlot()
        stack.PushSlot(slot1)
        stack.PushSlot(slot3)
        stack.PushSlot(slot2)
        stack.PushSlot(slot1)
    }*/

    @Override
    public void Execute(Frame frame) {
        Slot slot1=frame.operandStack.popSlot();
        Slot slot2=frame.operandStack.popSlot();
        Slot slot3=frame.operandStack.popSlot();
        frame.operandStack.pushSlot(slot1);
        frame.operandStack.pushSlot(slot3);
        frame.operandStack.pushSlot(slot2);
        frame.operandStack.pushSlot(slot1);
    }
}
