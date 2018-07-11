package ch06.instructions.stores.astore;

import ch06.instructions.base.instruction.NoOperandsInstruction;
import ch06.instructions.stores.astore._ASTORE;
import ch06.rtda.Frame;
import org.joou.UInteger;

public class ASTORE_0 extends NoOperandsInstruction {
    @Override
    public void Execute(Frame frame) {
        _ASTORE._astore(frame, UInteger.valueOf(0));
    }
}
