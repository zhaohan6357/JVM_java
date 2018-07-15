package ch07.instructions.math.add;

import ch07.instructions.base.instruction.NoOperandsInstruction;
import ch07.rtda.Frame;

public class LADD extends NoOperandsInstruction {
    @Override
    public void Execute(Frame frame) {
        long v1=frame.operandStack.popLong();
        long v2=frame.operandStack.popLong();
        long result = v1+v2;
        frame.operandStack.pushLong(result);
    }
}
