package ch07.instructions.math.rem;

import ch07.instructions.base.instruction.NoOperandsInstruction;
import ch07.rtda.Frame;

public class IREM extends NoOperandsInstruction {
/*    type IREM struct{ base.NoOperandsInstruction }

    func (self *IREM) Execute(frame *rtda.Frame) {
        stack := frame.OperandStack()
        v2 := stack.PopInt()
        v1 := stack.PopInt()
        if v2 == 0 {
            panic("java.lang.ArithmeticException: / by zero")
        }

        result := v1 % v2
        stack.PushInt(result)
    }*/

    @Override
    public void Execute(Frame frame) {
        int v2 = frame.operandStack.popInt();
        int v1 = frame.operandStack.popInt();
        if (v2 == 0) {
            System.out.println("java.lang.ArithmeticException: / by zero");
            System.exit(1);
        }
        int result = v1 % v2;
        frame.operandStack.pushInt(result);
    }
}
