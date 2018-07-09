package ch05.instructions.stores.lscore;

import ch05.instructions.base.instruction.NoOperandsInstruction;
import ch05.rtda.Frame;
import org.joou.UInteger;

public class LSTORE_3 extends NoOperandsInstruction {
    public void Execute(Frame frame) {
        _LSTORE._lstore(frame, UInteger.valueOf(3));
    }
}
