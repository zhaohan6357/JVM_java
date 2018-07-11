package ch06.instructions.math.add;

import ch06.instructions.base.instruction.NoOperandsInstruction;
import ch06.rtda.Frame;

public class DADD extends NoOperandsInstruction {
    @Override
    public void Execute(Frame frame) {
        double d1=frame.operandStack.popDouble();
        double d2=frame.operandStack.popDouble();
        double result=d1+d2;
        frame.operandStack.pushDouble(result);
    }
}
