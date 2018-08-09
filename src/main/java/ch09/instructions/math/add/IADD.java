package ch09.instructions.math.add;

import ch09.instructions.base.instruction.NoOperandsInstruction;
import ch09.rtda.Frame;

public class IADD extends NoOperandsInstruction {
    @Override
    public void Execute(Frame frame) {
        int v1=frame.operandStack.popInt();
        int v2=frame.operandStack.popInt();
        int result=v1+v2;
        frame.operandStack.pushInt(result);
    }
}
