package ch05.instructions.stores.astore;

import ch05.instructions.base.instruction.NoOperandsInstruction;
import ch05.rtda.Frame;
import org.joou.UInteger;

public class ASTORE_3 extends NoOperandsInstruction {
    @Override
    public void Execute(Frame frame) {
        _ASTORE._astore(frame, UInteger.valueOf(3));
    }
}
