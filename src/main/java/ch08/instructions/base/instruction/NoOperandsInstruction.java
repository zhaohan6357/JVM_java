package ch08.instructions.base.instruction;

import ch08.instructions.base.ByteCodeReader;
import ch08.instructions.base.instruction.Instruction;

public class NoOperandsInstruction extends Instruction{
    @Override
    public void FetchOperands(ByteCodeReader reader) {
        //do nothing
    }

}
