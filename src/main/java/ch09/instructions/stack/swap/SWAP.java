package ch09.instructions.stack.swap;

import ch09.instructions.base.instruction.NoOperandsInstruction;
import ch09.rtda.Frame;
import ch09.rtda.Slot;

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
