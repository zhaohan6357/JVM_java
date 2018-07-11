package ch06.instructions.math.mul;

import ch06.instructions.base.instruction.NoOperandsInstruction;
import ch06.rtda.Frame;

public class DMUL extends NoOperandsInstruction {


    @Override
    public void Execute(Frame frame) {
        double v2=frame.operandStack.popDouble();
        double v1=frame.operandStack.popDouble();
        double result=v1*v2;
        frame.operandStack.pushDouble(result);
    }
}
