package ch07.instructions.math.mul;

import ch07.instructions.base.instruction.NoOperandsInstruction;
import ch07.rtda.Frame;

public class FMUL extends NoOperandsInstruction{

    @Override
    public void Execute(Frame frame) {
        float v2=frame.operandStack.popFloat();
        float v1=frame.operandStack.popFloat();
        float result=v1*v2;
        frame.operandStack.pushFloat(result);
    }
}
