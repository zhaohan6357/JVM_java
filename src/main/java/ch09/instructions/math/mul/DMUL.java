package ch09.instructions.math.mul;

import ch09.instructions.base.instruction.NoOperandsInstruction;
import ch09.rtda.Frame;

public class DMUL extends NoOperandsInstruction {


    @Override
    public void Execute(Frame frame) {
        double v2=frame.operandStack.popDouble();
        double v1=frame.operandStack.popDouble();
        double result=v1*v2;
        frame.operandStack.pushDouble(result);
    }
}
