package ch08.instructions.stores.dstore;

import ch08.instructions.base.instruction.NoOperandsInstruction;
import ch08.instructions.stores.dstore._DSTORE;
import ch08.rtda.Frame;
import org.joou.UInteger;

public class DSTORE_2 extends NoOperandsInstruction {
    @Override
    public void Execute(Frame frame) {
        _DSTORE._dstore(frame, UInteger.valueOf(2));
    }
}
