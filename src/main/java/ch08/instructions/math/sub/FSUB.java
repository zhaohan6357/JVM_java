package ch08.instructions.math.sub;

import ch08.instructions.base.instruction.NoOperandsInstruction;
import ch08.rtda.Frame;

public class FSUB extends NoOperandsInstruction {
    @Override
    public void Execute(Frame frame) {
        float v2=frame.operandStack.popFloat();
        float v1=frame.operandStack.popFloat();
        float result=v1-v2;
        frame.operandStack.pushFloat(result);
    }
}
