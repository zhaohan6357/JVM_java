package ch07.instructions.loads.lload;

import ch07.instructions.base.instruction.NoOperandsInstruction;
import ch07.instructions.loads.lload._LLOAD;
import ch07.rtda.Frame;
import org.joou.UInteger;

public class LLOAD_1 extends NoOperandsInstruction {
    public void Execute(Frame frame) {
        _LLOAD._lload(frame, UInteger.valueOf(1));
    }
}
