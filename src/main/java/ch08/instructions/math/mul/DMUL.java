package ch08.instructions.math.mul;

import ch08.instructions.base.instruction.NoOperandsInstruction;
import ch08.rtda.Frame;

public class DMUL extends NoOperandsInstruction {


    @Override
    public void Execute(Frame frame) {
        double v2=frame.operandStack.popDouble();
        double v1=frame.operandStack.popDouble();
        double result=v1*v2;
        frame.operandStack.pushDouble(result);
    }
}
