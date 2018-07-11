package ch06.instructions.base.instruction;

import ch06.instructions.base.ByteCodeReader;
import ch06.instructions.base.instruction.Instruction;

public class NoOperandsInstruction extends Instruction{
    @Override
    public void FetchOperands(ByteCodeReader reader) {
        //do nothing
    }

}
