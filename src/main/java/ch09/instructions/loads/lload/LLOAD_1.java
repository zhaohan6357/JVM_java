package ch09.instructions.loads.lload;

import ch09.instructions.base.instruction.NoOperandsInstruction;
import ch09.instructions.loads.lload._LLOAD;
import ch09.rtda.Frame;
import org.joou.UInteger;

public class LLOAD_1 extends NoOperandsInstruction {
    public void Execute(Frame frame) {
        _LLOAD._lload(frame, UInteger.valueOf(1));
    }
}
