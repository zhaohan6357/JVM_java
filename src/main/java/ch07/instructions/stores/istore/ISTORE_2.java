package ch07.instructions.stores.istore;

import ch07.instructions.base.instruction.NoOperandsInstruction;
import ch07.instructions.stores.istore._ISTORE;
import ch07.rtda.Frame;
import org.joou.UInteger;

public class ISTORE_2 extends NoOperandsInstruction {
    @Override
    public void Execute(Frame frame) {
        _ISTORE._istore(frame, UInteger.valueOf(2));
    }
}
