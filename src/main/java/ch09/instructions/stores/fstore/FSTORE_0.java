package ch09.instructions.stores.fstore;

import ch09.instructions.base.instruction.NoOperandsInstruction;
import ch09.instructions.stores.fstore._FSTORE;
import ch09.rtda.Frame;
import org.joou.UInteger;

public class FSTORE_0 extends NoOperandsInstruction {

    @Override
    public void Execute(Frame frame) {
        _FSTORE._fstore(frame, UInteger.valueOf(0));
    }
}
