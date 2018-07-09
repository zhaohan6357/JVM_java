package ch05.instructions.math.mul;

import ch05.instructions.base.instruction.NoOperandsInstruction;
import ch05.rtda.Frame;

public class FMUL extends NoOperandsInstruction{

    @Override
    public void Execute(Frame frame) {
        float v2=frame.operandStack.popFloat();
        float v1=frame.operandStack.popFloat();
        float result=v1*v2;
        frame.operandStack.pushFloat(result);
    }
}
