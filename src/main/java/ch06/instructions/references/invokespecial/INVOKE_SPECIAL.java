package ch06.instructions.references.invokespecial;

import ch06.instructions.base.instruction.Index16Instruction;
import ch06.rtda.Frame;

public class INVOKE_SPECIAL extends Index16Instruction{
    @Override
    public void Execute(Frame frame) {
        frame.operandStack.popRef();
    }
}
