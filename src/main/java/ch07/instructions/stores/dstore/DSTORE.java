package ch07.instructions.stores.dstore;

import ch07.instructions.base.instruction.Index8Instruction;
import ch07.instructions.stores.dstore._DSTORE;
import ch07.rtda.Frame;

public class DSTORE extends Index8Instruction {
    @Override
    public void Execute(Frame frame) {
        _DSTORE._dstore(frame,index);
    }
}
