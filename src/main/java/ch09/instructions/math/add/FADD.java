package ch09.instructions.math.add;

import ch09.instructions.base.instruction.NoOperandsInstruction;
import ch09.rtda.Frame;

public class FADD extends NoOperandsInstruction {
    @Override
    public void Execute(Frame frame) {
        float v1=frame.operandStack.popFloat();
        float v2=frame.operandStack.popFloat();
        float result=v1+v2;
        frame.operandStack.pushFloat(result);
    }
}
