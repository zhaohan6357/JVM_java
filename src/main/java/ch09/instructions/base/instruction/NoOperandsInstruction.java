package ch09.instructions.base.instruction;

import ch09.instructions.base.ByteCodeReader;
import ch09.instructions.base.instruction.Instruction;

public class NoOperandsInstruction extends Instruction{
    @Override
    public void FetchOperands(ByteCodeReader reader) {
        //do nothing
    }

}
