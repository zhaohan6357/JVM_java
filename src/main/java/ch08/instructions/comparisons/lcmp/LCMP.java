package ch08.instructions.comparisons.lcmp;

import ch08.instructions.base.instruction.NoOperandsInstruction;
import ch08.rtda.Frame;

public class LCMP extends NoOperandsInstruction {
  /*  // Compare long
    type LCMP struct{ base.NoOperandsInstruction }
    func (self *LCMP) Execute(frame *rtda.Frame) {
        stack := frame.OperandStack()
        v2 := stack.PopLong()
        v1 := stack.PopLong()
        if v1 > v2 {
            stack.PushInt(1)
        } else if v1 == v2 {
            stack.PushInt(0)
        } else {
            stack.PushInt(-1)
        }
    }*/

    @Override
    public void Execute(Frame frame) {
        long v2=frame.operandStack.popLong();
        long v1=frame.operandStack.popLong();
        if(v1>v2){
            frame.operandStack.pushInt(1);
        }else if(v1==v2){
            frame.operandStack.pushInt(0);
        }else{
            frame.operandStack.pushInt(-1);
        }
    }
}
