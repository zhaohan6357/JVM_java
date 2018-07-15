package ch07.instructions.stores.astore;

import ch07.instructions.base.instruction.Index8Instruction;
import ch07.instructions.stores.astore._ASTORE;
import ch07.rtda.Frame;

public class ASTORE extends Index8Instruction{
    @Override
    public void Execute(Frame frame) {
        _ASTORE._astore(frame,index);
    }
}
