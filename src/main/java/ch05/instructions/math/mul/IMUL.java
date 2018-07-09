package ch05.instructions.math.mul;

import ch05.instructions.base.instruction.NoOperandsInstruction;
import ch05.rtda.Frame;

public class IMUL extends NoOperandsInstruction {


    @Override
    public void Execute(Frame frame) {
        int v2 = frame.operandStack.popInt();
        int v1 = frame.operandStack.popInt();
        if (v2 == 0) {
            System.out.println("java.lang.ArithmeticException: / by zero");
            System.exit(1);
        }
        int result = v1 * v2;
        frame.operandStack.pushInt(result);
    }
}
