package ch05.instructions.math.and;

import ch05.instructions.base.instruction.NoOperandsInstruction;
import ch05.rtda.Frame;

public class IAND extends NoOperandsInstruction{

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
        int result=v1& v2;
        frame.operandStack.pushInt(result);

    }
}
