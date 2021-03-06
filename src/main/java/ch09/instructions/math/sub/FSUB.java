package ch09.instructions.math.sub;

import ch09.instructions.base.instruction.NoOperandsInstruction;
import ch09.rtda.Frame;

public class FSUB extends NoOperandsInstruction {
    @Override
    public void Execute(Frame frame) {
        float v2=frame.operandStack.popFloat();
        float v1=frame.operandStack.popFloat();
        float result=v1-v2;
        frame.operandStack.pushFloat(result);
    }
}
