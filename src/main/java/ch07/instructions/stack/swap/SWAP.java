package ch07.instructions.stack.swap;

import ch07.instructions.base.instruction.NoOperandsInstruction;
import ch07.rtda.Frame;
import ch07.rtda.Slot;

public class SWAP extends NoOperandsInstruction {

/*    // Swap the top two operand stack values
    type SWAP struct{ base.NoOperandsInstruction }

    *//*
    bottom -> top
    [...][c][b][a]
              \/
              /\
             V  V
    [...][c][a][b]
    *//*
    func (self *SWAP) Execute(frame *rtda.Frame) {
        stack := frame.OperandStack()
        slot1 := stack.PopSlot()
        slot2 := stack.PopSlot()
        stack.PushSlot(slot1)
        stack.PushSlot(slot2)
    }*/

    @Override
    public void Execute(Frame frame) {
        Slot slot1=frame.operandStack.popSlot();
        Slot slot2=frame.operandStack.popSlot();
        frame.operandStack.pushSlot(slot1);
        frame.operandStack.pushSlot(slot2);
    }
}
