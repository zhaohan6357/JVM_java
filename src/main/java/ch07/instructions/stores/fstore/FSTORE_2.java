package ch07.instructions.stores.fstore;

import ch07.instructions.base.instruction.NoOperandsInstruction;
import ch07.instructions.stores.fstore._FSTORE;
import ch07.rtda.Frame;
import org.joou.UInteger;

public class FSTORE_2 extends NoOperandsInstruction {

    @Override
    public void Execute(Frame frame) {
        _FSTORE._fstore(frame, UInteger.valueOf(2));
    }
}
