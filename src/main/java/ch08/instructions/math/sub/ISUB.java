package ch08.instructions.math.sub;

import ch08.instructions.base.instruction.NoOperandsInstruction;
import ch08.rtda.Frame;

public class ISUB extends NoOperandsInstruction {
    @Override
    public void Execute(Frame frame) {
        int v2=frame.operandStack.popInt();
        int v1=frame.operandStack.popInt();
        int result=v1-v2;
        frame.operandStack.pushInt(result);
    }
}
