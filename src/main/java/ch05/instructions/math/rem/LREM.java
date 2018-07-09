package ch05.instructions.math.rem;

import ch05.instructions.base.instruction.NoOperandsInstruction;
import ch05.rtda.Frame;

public class LREM extends NoOperandsInstruction {
    @Override
    public void Execute(Frame frame) {
        long v2=frame.operandStack.popLong();
        long v1=frame.operandStack.popLong();
        if(v2==0){
            System.out.println("java.lang.ArithmeticException: / by zero");
            System.exit(1);
        }
        long result=v1%v2;
        frame.operandStack.pushLong(result);
    }
}
