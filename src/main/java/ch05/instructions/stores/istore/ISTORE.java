package ch05.instructions.stores.istore;

import ch05.instructions.base.instruction.Index8Instruction;
import ch05.rtda.Frame;

public class ISTORE extends Index8Instruction {

    @Override
    public void Execute(Frame frame) {
        _ISTORE._istore(frame,index);
    }
}
