package ch08.instructions.math.add;

import ch08.instructions.base.instruction.NoOperandsInstruction;
import ch08.rtda.Frame;

public class DADD extends NoOperandsInstruction {
    @Override
    public void Execute(Frame frame) {
        double d1=frame.operandStack.popDouble();
        double d2=frame.operandStack.popDouble();
        double result=d1+d2;
        frame.operandStack.pushDouble(result);
    }
}
