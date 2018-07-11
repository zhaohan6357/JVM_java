package ch06.instructions.stores.lscore;

import ch06.instructions.base.instruction.Index8Instruction;
import ch06.instructions.stores.lscore._LSTORE;
import ch06.rtda.Frame;

public class LSTORE extends Index8Instruction {
    @Override
    public void Execute(Frame frame) {
        _LSTORE._lstore(frame,index);
    }
}
