package ch06.instructions.loads.fload;

import ch06.instructions.base.instruction.NoOperandsInstruction;
import ch06.instructions.loads.fload._FLOAD;
import ch06.rtda.Frame;
import org.joou.UInteger;

public class FLOAD_3  extends NoOperandsInstruction {
    @Override
    public void Execute(Frame frame) {
        _FLOAD._fload(frame, UInteger.valueOf(3));
    }
}
