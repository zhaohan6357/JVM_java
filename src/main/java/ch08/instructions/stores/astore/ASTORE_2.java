package ch08.instructions.stores.astore;

import ch08.instructions.base.instruction.NoOperandsInstruction;
import ch08.instructions.stores.astore._ASTORE;
import ch08.rtda.Frame;
import org.joou.UInteger;

public class ASTORE_2 extends NoOperandsInstruction {
    @Override
    public void Execute(Frame frame) {
        _ASTORE._astore(frame, UInteger.valueOf(2));
    }
}
