package ch08.instructions.stores.fstore;

import ch08.instructions.base.instruction.NoOperandsInstruction;
import ch08.instructions.stores.fstore._FSTORE;
import ch08.rtda.Frame;
import org.joou.UInteger;

public class FSTORE_2 extends NoOperandsInstruction {

    @Override
    public void Execute(Frame frame) {
        _FSTORE._fstore(frame, UInteger.valueOf(2));
    }
}
