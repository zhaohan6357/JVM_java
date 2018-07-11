package ch06.instructions.loads.lload;

import ch06.instructions.base.instruction.NoOperandsInstruction;
import ch06.instructions.loads.lload._LLOAD;
import ch06.rtda.Frame;
import org.joou.UInteger;

public class LLOAD_1 extends NoOperandsInstruction {
    public void Execute(Frame frame) {
        _LLOAD._lload(frame, UInteger.valueOf(1));
    }
}
