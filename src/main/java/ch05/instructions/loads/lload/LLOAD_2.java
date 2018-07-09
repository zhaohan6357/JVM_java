package ch05.instructions.loads.lload;

import ch05.instructions.base.instruction.NoOperandsInstruction;
import ch05.rtda.Frame;
import org.joou.UInteger;

public class LLOAD_2 extends NoOperandsInstruction {
    public void Execute(Frame frame) {
        _LLOAD._lload(frame, UInteger.valueOf(2));
    }
}
