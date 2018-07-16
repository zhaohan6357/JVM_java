package ch08.instructions.loads.iload;

import ch08.instructions.loads.iload._ILOAD;
import ch08.rtda.Frame;
import ch08.instructions.base.instruction.NoOperandsInstruction;
import org.joou.UInteger;

public class ILOAD_1 extends NoOperandsInstruction {
    @Override
    public void Execute(Frame frame) {
        _ILOAD._ioad(frame, UInteger.valueOf(1));
    }
}
