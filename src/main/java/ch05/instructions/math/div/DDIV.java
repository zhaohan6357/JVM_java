package ch05.instructions.math.div;

import ch05.instructions.base.instruction.NoOperandsInstruction;
import ch05.rtda.Frame;

public class DDIV extends NoOperandsInstruction {

    @Override
    public void Execute(Frame frame) {
        double v2=frame.operandStack.popDouble();
        double v1=frame.operandStack.popDouble();
        double result=v1/v2;
        frame.operandStack.pushDouble(result);
    }
}
