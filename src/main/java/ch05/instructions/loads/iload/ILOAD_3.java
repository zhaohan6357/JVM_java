package ch05.instructions.loads.iload;

import ch05.rtda.Frame;
import ch05.instructions.base.instruction.NoOperandsInstruction;
import org.joou.UInteger;

public class ILOAD_3 extends NoOperandsInstruction {
    @Override
    public void Execute(Frame frame) {
        _ILOAD._ioad(frame, UInteger.valueOf(3));
    }
}
