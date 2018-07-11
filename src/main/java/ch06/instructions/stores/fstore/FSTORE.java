package ch06.instructions.stores.fstore;

import ch06.instructions.base.instruction.Index8Instruction;
import ch06.instructions.stores.fstore._FSTORE;
import ch06.rtda.Frame;

public class FSTORE extends Index8Instruction {

    @Override
    public void Execute(Frame frame) {
        _FSTORE._fstore(frame,index);
    }
}
