package ch05.instructions.stores.fstore;

import ch05.instructions.base.instruction.NoOperandsInstruction;
import ch05.rtda.Frame;
import org.joou.UInteger;

public class FSTORE_2 extends NoOperandsInstruction {

    @Override
    public void Execute(Frame frame) {
        _FSTORE._fstore(frame, UInteger.valueOf(2));
    }
}
