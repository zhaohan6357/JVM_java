package ch05.instructions.math.sh;

import ch05.instructions.base.instruction.NoOperandsInstruction;
import ch05.rtda.Frame;

public class ISHR extends NoOperandsInstruction {
    @Override
    public void Execute(Frame frame) {
        int v2=frame.operandStack.popInt();
        int v1=frame.operandStack.popInt();
        int s= v2&(0x1f);
        int result=v1>>s;
        frame.operandStack.pushInt(result);
    }

}
