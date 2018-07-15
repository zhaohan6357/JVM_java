package ch07.instructions.stores.lscore;

import ch07.instructions.base.instruction.Index8Instruction;
import ch07.instructions.stores.lscore._LSTORE;
import ch07.rtda.Frame;

public class LSTORE extends Index8Instruction {
    @Override
    public void Execute(Frame frame) {
        _LSTORE._lstore(frame,index);
    }
}
