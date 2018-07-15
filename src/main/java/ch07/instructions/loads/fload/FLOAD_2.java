package ch07.instructions.loads.fload;

import ch07.instructions.base.instruction.NoOperandsInstruction;
import ch07.instructions.loads.fload._FLOAD;
import ch07.rtda.Frame;
import org.joou.UInteger;

public class FLOAD_2  extends NoOperandsInstruction {
    @Override
    public void Execute(Frame frame) {
        _FLOAD._fload(frame, UInteger.valueOf(2));
    }
}
