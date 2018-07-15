package ch07.instructions.stores.dstore;

import ch07.instructions.base.instruction.NoOperandsInstruction;
import ch07.instructions.stores.dstore._DSTORE;
import ch07.rtda.Frame;
import org.joou.UInteger;

public class DSTORE_0 extends NoOperandsInstruction {
    @Override
    public void Execute(Frame frame) {
        _DSTORE._dstore(frame, UInteger.valueOf(0));
    }
}
