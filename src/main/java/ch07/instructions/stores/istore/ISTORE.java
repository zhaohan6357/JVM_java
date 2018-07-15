package ch07.instructions.stores.istore;

import ch07.instructions.base.instruction.Index8Instruction;
import ch07.instructions.stores.istore._ISTORE;
import ch07.rtda.Frame;

public class ISTORE extends Index8Instruction {

    @Override
    public void Execute(Frame frame) {
        _ISTORE._istore(frame,index);
    }
}
