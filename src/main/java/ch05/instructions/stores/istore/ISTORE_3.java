package ch05.instructions.stores.istore;

import ch05.instructions.base.instruction.NoOperandsInstruction;
import ch05.rtda.Frame;
import org.joou.UInteger;

public class ISTORE_3 extends NoOperandsInstruction {
    @Override
    public void Execute(Frame frame) {
        _ISTORE._istore(frame, UInteger.valueOf(3));
    }
}
