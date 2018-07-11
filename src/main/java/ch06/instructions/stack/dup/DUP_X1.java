package ch06.instructions.stack.dup;

import ch06.instructions.base.instruction.NoOperandsInstruction;
import ch06.rtda.Frame;
import ch06.rtda.Slot;

public class DUP_X1 extends NoOperandsInstruction {
/*    // Duplicate the top operand stack value and insert two values down
    type DUP_X1 struct{ base.NoOperandsInstruction }

    *//*
    bottom -> top
    [...][c][b][a]
              __/
             |
             V
    [...][c][a][b][a]
    *//*
    func (self *DUP_X1) Execute(frame *rtda.Frame) {
        stack := frame.OperandStack()
        slot1 := stack.PopSlot()
        slot2 := stack.PopSlot()
        stack.PushSlot(slot1)
        stack.PushSlot(slot2)
        stack.PushSlot(slot1)
    }*/

    @Override
    public void Execute(Frame frame) {
        Slot slot1=frame.operandStack.popSlot();
        Slot slot2=frame.operandStack.popSlot();
        frame.operandStack.pushSlot(slot1);
        frame.operandStack.pushSlot(slot2);
        frame.operandStack.pushSlot(slot1);
    }
}
