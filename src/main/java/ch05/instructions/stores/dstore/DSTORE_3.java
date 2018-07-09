package ch05.instructions.stores.dstore;

import ch05.instructions.base.instruction.NoOperandsInstruction;
import ch05.rtda.Frame;
import org.joou.UInteger;

public class DSTORE_3 extends NoOperandsInstruction {
    @Override
    public void Execute(Frame frame) {
        _DSTORE._dstore(frame, UInteger.valueOf(3));
    }
}
