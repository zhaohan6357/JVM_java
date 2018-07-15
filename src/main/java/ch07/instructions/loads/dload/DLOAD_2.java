package ch07.instructions.loads.dload;

import ch07.instructions.base.instruction.NoOperandsInstruction;
import ch07.instructions.loads.dload._DLOAD;
import ch07.rtda.Frame;
import org.joou.UInteger;

public class DLOAD_2 extends NoOperandsInstruction {
    @Override
    public void Execute(Frame frame) {
        _DLOAD._dload(frame, UInteger.valueOf(2));
    }
}
