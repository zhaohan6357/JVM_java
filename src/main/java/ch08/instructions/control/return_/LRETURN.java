package ch08.instructions.control.return_;

import ch08.instructions.base.instruction.NoOperandsInstruction;
import ch08.rtda.Frame;
import ch08.rtda.Thread;

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
