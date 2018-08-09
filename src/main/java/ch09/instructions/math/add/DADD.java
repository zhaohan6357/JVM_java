package ch09.instructions.math.add;

import ch09.instructions.base.instruction.NoOperandsInstruction;
import ch09.rtda.Frame;

public class DADD extends NoOperandsInstruction {
    @Override
    public void Execute(Frame frame) {
        double d1=frame.operandStack.popDouble();
        double d2=frame.operandStack.popDouble();
        double result=d1+d2;
        frame.operandStack.pushDouble(result);
    }
}
