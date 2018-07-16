package ch08.instructions.loads.fload;

import ch08.instructions.base.instruction.NoOperandsInstruction;
import ch08.instructions.loads.fload._FLOAD;
import ch08.rtda.Frame;
import org.joou.UInteger;

public class FLOAD_3  extends NoOperandsInstruction {
    @Override
    public void Execute(Frame frame) {
        _FLOAD._fload(frame, UInteger.valueOf(3));
    }
}
