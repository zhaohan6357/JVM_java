package ch06.instructions.math.add;

import ch06.instructions.base.instruction.NoOperandsInstruction;
import ch06.rtda.Frame;

public class FADD extends NoOperandsInstruction {
    @Override
    public void Execute(Frame frame) {
        float v1=frame.operandStack.popFloat();
        float v2=frame.operandStack.popFloat();
        float result=v1+v2;
        frame.operandStack.pushFloat(result);
    }
}
