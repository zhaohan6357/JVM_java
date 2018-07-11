package ch06.instructions.stores.dstore;

import ch06.instructions.base.instruction.NoOperandsInstruction;
import ch06.instructions.stores.dstore._DSTORE;
import ch06.rtda.Frame;
import org.joou.UInteger;

public class DSTORE_2 extends NoOperandsInstruction {
    @Override
    public void Execute(Frame frame) {
        _DSTORE._dstore(frame, UInteger.valueOf(2));
    }
}
