package ch09.instructions.loads.dload;

import ch09.instructions.base.instruction.NoOperandsInstruction;
import ch09.instructions.loads.dload._DLOAD;
import ch09.rtda.Frame;
import org.joou.UInteger;

public class DLOAD_1 extends NoOperandsInstruction {
    @Override
    public void Execute(Frame frame) {
        _DLOAD._dload(frame, UInteger.valueOf(1));
    }
}
