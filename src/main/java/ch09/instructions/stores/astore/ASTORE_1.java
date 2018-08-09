package ch09.instructions.stores.astore;

import ch09.instructions.base.instruction.NoOperandsInstruction;
import ch09.instructions.stores.astore._ASTORE;
import ch09.rtda.Frame;
import org.joou.UInteger;

public class ASTORE_1 extends NoOperandsInstruction {
    @Override
    public void Execute(Frame frame) {
        _ASTORE._astore(frame, UInteger.valueOf(1));
    }
}
