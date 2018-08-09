package ch09.instructions.control.return_;

import ch09.instructions.base.instruction.NoOperandsInstruction;
import ch09.rtda.Frame;
import ch09.rtda.Thread;

public class IRETURN extends NoOperandsInstruction{
    @Override
    public void Execute(Frame frame) {
        Thread thread=frame.thread;
        Frame currentFrame=thread.popFrame();
        Frame invokerFrame=thread.topFrame();
        int val=currentFrame.operandStack.popInt();
        invokerFrame.operandStack.pushInt(val);
    }
}
