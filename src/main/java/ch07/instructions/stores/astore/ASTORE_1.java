package ch07.instructions.stores.astore;

import ch07.instructions.base.instruction.NoOperandsInstruction;
import ch07.instructions.stores.astore._ASTORE;
import ch07.rtda.Frame;
import org.joou.UInteger;

public class ASTORE_1 extends NoOperandsInstruction {
    @Override
    public void Execute(Frame frame) {
        _ASTORE._astore(frame, UInteger.valueOf(1));
    }
}
