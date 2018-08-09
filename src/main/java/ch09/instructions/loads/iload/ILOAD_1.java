package ch09.instructions.loads.iload;

import ch09.instructions.loads.iload._ILOAD;
import ch09.rtda.Frame;
import ch09.instructions.base.instruction.NoOperandsInstruction;
import org.joou.UInteger;

public class ILOAD_1 extends NoOperandsInstruction {
    @Override
    public void Execute(Frame frame) {
        _ILOAD._ioad(frame, UInteger.valueOf(1));
    }
}
