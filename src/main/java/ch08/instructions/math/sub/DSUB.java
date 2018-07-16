package ch08.instructions.math.sub;

import ch08.instructions.base.instruction.NoOperandsInstruction;
import ch08.rtda.Frame;

public class DSUB extends NoOperandsInstruction {
    @Override
    public void Execute(Frame frame) {
        double d2=frame.operandStack.popDouble();
        double d1=frame.operandStack.popDouble();
        double result=d1-d2;
        frame.operandStack.pushDouble(result);
    }
}
