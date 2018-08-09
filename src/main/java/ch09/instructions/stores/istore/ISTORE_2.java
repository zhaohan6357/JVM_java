package ch09.instructions.stores.istore;

import ch09.instructions.base.instruction.NoOperandsInstruction;
import ch09.instructions.stores.istore._ISTORE;
import ch09.rtda.Frame;
import org.joou.UInteger;

public class ISTORE_2 extends NoOperandsInstruction {
    @Override
    public void Execute(Frame frame) {
        _ISTORE._istore(frame, UInteger.valueOf(2));
    }
}
