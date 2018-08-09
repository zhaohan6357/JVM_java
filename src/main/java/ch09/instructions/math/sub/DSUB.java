package ch09.instructions.math.sub;

import ch09.instructions.base.instruction.NoOperandsInstruction;
import ch09.rtda.Frame;

public class DSUB extends NoOperandsInstruction {
    @Override
    public void Execute(Frame frame) {
        double d2=frame.operandStack.popDouble();
        double d1=frame.operandStack.popDouble();
        double result=d1-d2;
        frame.operandStack.pushDouble(result);
    }
}
