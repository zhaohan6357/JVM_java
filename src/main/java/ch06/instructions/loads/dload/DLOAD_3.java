package ch06.instructions.loads.dload;

import ch06.instructions.base.instruction.NoOperandsInstruction;
import ch06.instructions.loads.dload._DLOAD;
import ch06.rtda.Frame;
import org.joou.UInteger;

public class DLOAD_3 extends NoOperandsInstruction {
    @Override
    public void Execute(Frame frame) {
        _DLOAD._dload(frame, UInteger.valueOf(3));
    }
}
