package ch09.instructions.loads.fload;

import ch09.instructions.base.instruction.NoOperandsInstruction;
import ch09.instructions.loads.fload._FLOAD;
import ch09.rtda.Frame;
import org.joou.UInteger;

public class FLOAD_1  extends NoOperandsInstruction {
    @Override
    public void Execute(Frame frame) {
        _FLOAD._fload(frame, UInteger.valueOf(1));
    }
}
