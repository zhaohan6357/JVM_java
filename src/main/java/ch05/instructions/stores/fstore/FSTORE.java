package ch05.instructions.stores.fstore;

import ch05.instructions.base.instruction.Index8Instruction;
import ch05.rtda.Frame;

public class FSTORE extends Index8Instruction {

    @Override
    public void Execute(Frame frame) {
        _FSTORE._fstore(frame,index);
    }
}
