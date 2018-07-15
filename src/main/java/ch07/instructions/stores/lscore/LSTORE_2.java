package ch07.instructions.stores.lscore;

import ch07.instructions.base.instruction.NoOperandsInstruction;
import ch07.instructions.stores.lscore._LSTORE;
import ch07.rtda.Frame;
import org.joou.UInteger;

public class LSTORE_2 extends NoOperandsInstruction {
    public void Execute(Frame frame) {
        _LSTORE._lstore(frame, UInteger.valueOf(2));
    }
}
