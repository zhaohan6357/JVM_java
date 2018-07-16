package ch08.instructions.stores.lscore;

import ch08.instructions.base.instruction.Index8Instruction;
import ch08.instructions.stores.lscore._LSTORE;
import ch08.rtda.Frame;

public class LSTORE extends Index8Instruction {
    @Override
    public void Execute(Frame frame) {
        _LSTORE._lstore(frame,index);
    }
}
