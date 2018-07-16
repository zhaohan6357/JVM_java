package ch08.instructions.stores.fstore;

import ch08.instructions.base.instruction.Index8Instruction;
import ch08.instructions.stores.fstore._FSTORE;
import ch08.rtda.Frame;

public class FSTORE extends Index8Instruction {

    @Override
    public void Execute(Frame frame) {
        _FSTORE._fstore(frame,index);
    }
}
