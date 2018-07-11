package ch06.instructions.math.sh;

import ch06.instructions.base.instruction.NoOperandsInstruction;
import ch06.rtda.Frame;

public class IUSHR extends NoOperandsInstruction {
    @Override
    public void Execute(Frame frame) {
        int v2=frame.operandStack.popInt();
        int v1=frame.operandStack.popInt();
        int s= v2 &(0x1f);
        int result=v1>>>s;
        frame.operandStack.pushInt(result);
    }
}
