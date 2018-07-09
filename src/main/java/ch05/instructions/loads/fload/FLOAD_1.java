package ch05.instructions.loads.fload;

import ch05.instructions.base.instruction.NoOperandsInstruction;
import ch05.rtda.Frame;
import org.joou.UInteger;

public class FLOAD_1  extends NoOperandsInstruction {
    @Override
    public void Execute(Frame frame) {
        _FLOAD._fload(frame, UInteger.valueOf(1));
    }
}
