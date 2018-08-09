package ch09.instructions.stores.dstore;

import ch09.instructions.base.instruction.NoOperandsInstruction;
import ch09.instructions.stores.dstore._DSTORE;
import ch09.rtda.Frame;
import org.joou.UInteger;

public class DSTORE_1 extends NoOperandsInstruction {
    @Override
    public void Execute(Frame frame) {
        _DSTORE._dstore(frame, UInteger.valueOf(1));
    }
}
