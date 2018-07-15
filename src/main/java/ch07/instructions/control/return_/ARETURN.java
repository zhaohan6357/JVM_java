package ch07.instructions.control.return_;

import ch07.instructions.base.instruction.NoOperandsInstruction;
import ch07.rtda.Frame;
import ch07.rtda.Thread;
import ch07.rtda.heap.Object;

public class ARETURN extends NoOperandsInstruction {
    @Override
    public void Execute(Frame frame) {
        Thread thread=frame.thread;
        Frame currentFrame=thread.popFrame();
        Frame invokerFrame=thread.topFrame();
        Object ref=currentFrame.operandStack.popRef();
        invokerFrame.operandStack.pushRef(ref);
    }
}
