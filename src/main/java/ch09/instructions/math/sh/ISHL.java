package ch09.instructions.math.sh;

import ch09.instructions.base.instruction.NoOperandsInstruction;
import ch09.rtda.Frame;

public class ISHL extends NoOperandsInstruction {
    /*type ISHL struct{ base.NoOperandsInstruction }

    func (self *ISHL) Execute(frame *rtda.Frame) {
        stack := frame.OperandStack()
        v2 := stack.PopInt()
        v1 := stack.PopInt()
        s := uint32(v2) new  0x1f
        result := v1 << s
        stack.PushInt(result)
    }*/

    @Override
    public void Execute(Frame frame) {
        int v2=frame.operandStack.popInt();
        int v1=frame.operandStack.popInt();
        int s= v2 & (0x1f);
        int result=v1<<s;
        frame.operandStack.pushInt(result);
    }
}
