package ch09.instructions.stores.fstore;

import ch09.instructions.base.instruction.Index8Instruction;
import ch09.instructions.stores.fstore._FSTORE;
import ch09.rtda.Frame;

public class FSTORE extends Index8Instruction {

    @Override
    public void Execute(Frame frame) {
        _FSTORE._fstore(frame,index);
    }
}
