package ch06.instructions.stores.dstore;

import ch06.instructions.base.instruction.Index8Instruction;
import ch06.instructions.stores.dstore._DSTORE;
import ch06.rtda.Frame;

public class DSTORE extends Index8Instruction {
    @Override
    public void Execute(Frame frame) {
        _DSTORE._dstore(frame,index);
    }
}
