package ch09.instructions.stores.lscore;

import ch09.instructions.base.instruction.Index8Instruction;
import ch09.instructions.stores.lscore._LSTORE;
import ch09.rtda.Frame;

public class LSTORE extends Index8Instruction {
    @Override
    public void Execute(Frame frame) {
        _LSTORE._lstore(frame,index);
    }
}
