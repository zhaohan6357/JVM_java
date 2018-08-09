package ch09.instructions.stores.istore;

import ch09.instructions.base.instruction.Index8Instruction;
import ch09.instructions.stores.istore._ISTORE;
import ch09.rtda.Frame;

public class ISTORE extends Index8Instruction {

    @Override
    public void Execute(Frame frame) {
        _ISTORE._istore(frame,index);
    }
}
