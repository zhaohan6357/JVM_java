package ch07.instructions.control.return_;

import ch07.instructions.base.instruction.NoOperandsInstruction;
import ch07.rtda.Frame;
import ch07.rtda.Thread;

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
