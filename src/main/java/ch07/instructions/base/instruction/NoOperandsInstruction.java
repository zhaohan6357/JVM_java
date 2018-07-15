package ch07.instructions.base.instruction;

import ch07.instructions.base.ByteCodeReader;
import ch07.instructions.base.instruction.Instruction;

public class NoOperandsInstruction extends Instruction{
    @Override
    public void FetchOperands(ByteCodeReader reader) {
        //do nothing
    }

}
