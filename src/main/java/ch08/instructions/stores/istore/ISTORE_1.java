package ch08.instructions.stores.istore;

import ch08.instructions.base.instruction.NoOperandsInstruction;
import ch08.instructions.stores.istore._ISTORE;
import ch08.rtda.Frame;
import org.joou.UInteger;

public class ISTORE_1 extends NoOperandsInstruction{
    @Override
    public void Execute(Frame frame) {
        _ISTORE._istore(frame, UInteger.valueOf(1));
    }
}
