package ch07.instructions.stores.fstore;

import ch07.instructions.base.instruction.Index8Instruction;
import ch07.instructions.stores.fstore._FSTORE;
import ch07.rtda.Frame;

public class FSTORE extends Index8Instruction {

    @Override
    public void Execute(Frame frame) {
        _FSTORE._fstore(frame,index);
    }
}
