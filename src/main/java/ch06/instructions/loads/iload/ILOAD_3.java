package ch06.instructions.loads.iload;

import ch06.instructions.loads.iload._ILOAD;
import ch06.rtda.Frame;
import ch06.instructions.base.instruction.NoOperandsInstruction;
import org.joou.UInteger;

public class ILOAD_3 extends NoOperandsInstruction {
    @Override
    public void Execute(Frame frame) {
        _ILOAD._ioad(frame, UInteger.valueOf(3));
    }
}
