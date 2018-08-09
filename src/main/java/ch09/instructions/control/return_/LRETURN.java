package ch09.instructions.control.return_;

import ch09.instructions.base.instruction.NoOperandsInstruction;
import ch09.rtda.Frame;
import ch09.rtda.Thread;

public class LRETURN extends NoOperandsInstruction {
    @Override
    public void Execute(Frame frame) {
        Thread thread=frame.thread;
        Frame currentFrame=thread.popFrame();
        Frame invokerFrame=thread.topFrame();
        long val=currentFrame.operandStack.popLong();
        invokerFrame.operandStack.pushLong(val);
    }
}
