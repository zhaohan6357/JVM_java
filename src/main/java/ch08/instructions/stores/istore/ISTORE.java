package ch08.instructions.stores.istore;

import ch08.instructions.base.instruction.Index8Instruction;
import ch08.instructions.stores.istore._ISTORE;
import ch08.rtda.Frame;

public class ISTORE extends Index8Instruction {

    @Override
    public void Execute(Frame frame) {
        _ISTORE._istore(frame,index);
    }
}
