package ch07.instructions.loads.iload;

import ch07.instructions.loads.iload._ILOAD;
import ch07.rtda.Frame;
import ch07.instructions.base.instruction.NoOperandsInstruction;
import org.joou.UInteger;

public class ILOAD_2 extends NoOperandsInstruction {
    @Override
    public void Execute(Frame frame) {
        _ILOAD._ioad(frame, UInteger.valueOf(2));
    }
}
