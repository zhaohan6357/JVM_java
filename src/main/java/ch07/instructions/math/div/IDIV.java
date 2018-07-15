package ch07.instructions.math.div;

import ch07.instructions.base.instruction.NoOperandsInstruction;
import ch07.rtda.Frame;

public class IDIV extends NoOperandsInstruction {

    @Override
    public void Execute(Frame frame) {
        int v2 = frame.operandStack.popInt();
        int v1 = frame.operandStack.popInt();
        if (v2 == 0) {
            System.out.println("java.lang.ArithmeticException: / by zero");
            System.exit(1);
        }
        int result = v1 / v2;
        frame.operandStack.pushInt(result);
    }
}
