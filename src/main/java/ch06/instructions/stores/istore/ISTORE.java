package ch06.instructions.stores.istore;

import ch06.instructions.base.instruction.Index8Instruction;
import ch06.instructions.stores.istore._ISTORE;
import ch06.rtda.Frame;

public class ISTORE extends Index8Instruction {

    @Override
    public void Execute(Frame frame) {
        _ISTORE._istore(frame,index);
    }
}
