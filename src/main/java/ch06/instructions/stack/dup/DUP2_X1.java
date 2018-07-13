package ch06.instructions.stack.dup;

import ch06.instructions.base.instruction.NoOperandsInstruction;
import ch06.rtda.Frame;
import ch06.rtda.Slot;

public class DUP2_X1 extends NoOperandsInstruction {
    /*// Duplicate the top one or two operand stack values and insert two or three values down
    type DUP2_X1 struct{ base.NoOperandsInstruction }

    *//*
    bottom -> top
    [...][c][b][a]
           _/ __/
          |  |
          V  V
    [...][b][a][c][b][a]
    *//*
    func (self *DUP2_X1) Execute(frame *rtda.Frame) {
        stack := frame.OperandStack()
        slot1 := stack.PopSlot()
        slot2 := stack.PopSlot()
        slot3 := stack.PopSlot()
        stack.PushSlot(slot2)
        stack.PushSlot(slot1)
        stack.PushSlot(slot3)
        stack.PushSlot(slot2)
        stack.PushSlot(slot1)
    }*/

    @Override
    public void Execute(Frame frame) {
        Slot slot1=frame.operandStack.popSlot();
        Slot slot11=new Slot(slot1.num,slot1.ref);
        Slot slot2=frame.operandStack.popSlot();
        Slot slot21=new Slot(slot2.num,slot2.ref);
        Slot slot3=frame.operandStack.popSlot();
        frame.operandStack.pushSlot(slot21);
        frame.operandStack.pushSlot(slot11);
        frame.operandStack.pushSlot(slot3);
        frame.operandStack.pushSlot(slot2);
        frame.operandStack.pushSlot(slot1);
    }
}
