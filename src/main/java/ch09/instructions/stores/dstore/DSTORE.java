package ch09.instructions.stores.dstore;

import ch09.instructions.base.instruction.Index8Instruction;
import ch09.instructions.stores.dstore._DSTORE;
import ch09.rtda.Frame;

public class DSTORE extends Index8Instruction {
    @Override
    public void Execute(Frame frame) {
        _DSTORE._dstore(frame,index);
    }
}
