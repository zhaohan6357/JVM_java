package ch09.instructions.stores.lscore;

import ch09.instructions.base.instruction.NoOperandsInstruction;
import ch09.instructions.stores.lscore._LSTORE;
import ch09.rtda.Frame;
import org.joou.UInteger;

public class LSTORE_1 extends NoOperandsInstruction {
    public void Execute(Frame frame) {
        _LSTORE._lstore(frame, UInteger.valueOf(1));
    }
}
