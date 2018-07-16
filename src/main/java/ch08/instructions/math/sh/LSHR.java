package ch08.instructions.math.sh;

import ch08.instructions.base.instruction.NoOperandsInstruction;
import ch08.rtda.Frame;

public class LSHR extends NoOperandsInstruction{
    /*    func (self *LSHR) Execute(frame *rtda.Frame) {
        stack := frame.OperandStack()
        v2 := stack.PopInt()
        v1 := stack.PopLong()
        s := uint32(v2) new  0x3f
        result := v1 >> s
        stack.PushLong(result)
    }*/

    @Override
    public void Execute(Frame frame) {
        int v2=frame.operandStack.popInt();
        long v1=frame.operandStack.popLong();
        int s=v2&0x3f;
        long result=v1>>s;
        frame.operandStack.pushLong(result);
    }
}
