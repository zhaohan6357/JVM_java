package ch05.instructions.stores.lscore;

import ch05.instructions.base.instruction.Index8Instruction;
import ch05.rtda.Frame;

public class LSTORE extends Index8Instruction {
    @Override
    public void Execute(Frame frame) {
        _LSTORE._lstore(frame,index);
    }
}
