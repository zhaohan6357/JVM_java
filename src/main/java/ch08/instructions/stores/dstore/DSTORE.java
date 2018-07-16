package ch08.instructions.stores.dstore;

import ch08.instructions.base.instruction.Index8Instruction;
import ch08.instructions.stores.dstore._DSTORE;
import ch08.rtda.Frame;

public class DSTORE extends Index8Instruction {
    @Override
    public void Execute(Frame frame) {
        _DSTORE._dstore(frame,index);
    }
}
