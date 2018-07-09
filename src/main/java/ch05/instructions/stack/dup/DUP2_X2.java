package ch05.instructions.stack.dup;

import ch05.instructions.base.instruction.NoOperandsInstruction;
import ch05.rtda.Frame;
import ch05.rtda.Slot;

public class DUP2_X2 extends NoOperandsInstruction {
    /*// Duplicate the top one or two operand stack values and insert two, three, or four values down
    type DUP2_X2 struct{ base.NoOperandsInstruction }

    *//*
    bottom -> top
    [...][d][c][b][a]
           ____/ __/
          |   __/
          V  V
    [...][b][a][d][c][b][a]
    *//*
    func (self *DUP2_X2) Execute(frame *rtda.Frame) {
        stack := frame.OperandStack()
        slot1 := stack.PopSlot()
        slot2 := stack.PopSlot()
        slot3 := stack.PopSlot()
        slot4 := stack.PopSlot()
        stack.PushSlot(slot2)
        stack.PushSlot(slot1)
        stack.PushSlot(slot4)
        stack.PushSlot(slot3)
        stack.PushSlot(slot2)
        stack.PushSlot(slot1)
    }*/

    @Override
    public void Execute(Frame frame) {
        Slot slot1 = frame.operandStack.popSlot();
        Slot slot2 = frame.operandStack.popSlot();
        Slot slot3 = frame.operandStack.popSlot();
        Slot slot4 = frame.operandStack.popSlot();
        frame.operandStack.pushSlot(slot2);
        frame.operandStack.pushSlot(slot1);
        frame.operandStack.pushSlot(slot4);
        frame.operandStack.pushSlot(slot3);
        frame.operandStack.pushSlot(slot2);
        frame.operandStack.pushSlot(slot1);

    }
}
