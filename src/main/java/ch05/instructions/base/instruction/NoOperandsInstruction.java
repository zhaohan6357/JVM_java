package ch05.instructions.base.instruction;

import ch05.instructions.base.ByteCodeReader;

public class NoOperandsInstruction extends Instruction{
    @Override
    public void FetchOperands(ByteCodeReader reader) {
        //do nothing
    }

}
