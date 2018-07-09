package ch05.instructions.math.add;

import ch05.instructions.base.instruction.NoOperandsInstruction;
import ch05.rtda.Frame;

public class IADD extends NoOperandsInstruction {
    @Override
    public void Execute(Frame frame) {
        int v1=frame.operandStack.popInt();
        int v2=frame.operandStack.popInt();
        int result=v1+v2;
        frame.operandStack.pushInt(result);
    }
}
