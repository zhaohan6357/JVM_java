package ch05.instructions.math.sh;

import ch05.instructions.base.instruction.NoOperandsInstruction;
import ch05.rtda.Frame;

public class LUSHR extends NoOperandsInstruction {
    @Override
    public void Execute(Frame frame) {
        int v2=frame.operandStack.popInt();
        long v1=frame.operandStack.popLong();
        int s=v2&0x3f;
        long result=v1>>>s;
        frame.operandStack.pushLong(result);
    }
}
