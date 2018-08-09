package ch09.instructions.math.or;

import ch09.instructions.base.instruction.NoOperandsInstruction;
import ch09.rtda.Frame;

public class IOR extends NoOperandsInstruction{

/*    func (self *IAND) Execute(frame *rtda.Frame) {
        stack := frame.OperandStack()
        v2 := stack.PopInt()
        v1 := stack.PopInt()
        result := v1 new  v2
        stack.PushInt(result)
    }*/

    @Override
    public void Execute(Frame frame) {
        int v2=frame.operandStack.popInt();
        int v1=frame.operandStack.popInt();
        int result=v1|v2;
        frame.operandStack.pushInt(result);

    }
}
