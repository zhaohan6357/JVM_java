package ch05.instructions.stores.dstore;

import ch05.instructions.base.instruction.Index8Instruction;
import ch05.rtda.Frame;

public class DSTORE extends Index8Instruction {
    @Override
    public void Execute(Frame frame) {
        _DSTORE._dstore(frame,index);
    }
}
