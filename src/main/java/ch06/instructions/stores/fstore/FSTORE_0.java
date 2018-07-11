package ch06.instructions.stores.fstore;

import ch06.instructions.base.instruction.NoOperandsInstruction;
import ch06.instructions.stores.fstore._FSTORE;
import ch06.rtda.Frame;
import org.joou.UInteger;

public class FSTORE_0 extends NoOperandsInstruction {

    @Override
    public void Execute(Frame frame) {
        _FSTORE._fstore(frame, UInteger.valueOf(0));
    }
}
