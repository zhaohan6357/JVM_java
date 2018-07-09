package ch05.instructions.loads.dload;

import ch05.instructions.base.instruction.NoOperandsInstruction;
import ch05.rtda.Frame;
import org.joou.UInteger;

public class DLOAD_2 extends NoOperandsInstruction {
    @Override
    public void Execute(Frame frame) {
        _DLOAD._dload(frame, UInteger.valueOf(2));
    }
}
