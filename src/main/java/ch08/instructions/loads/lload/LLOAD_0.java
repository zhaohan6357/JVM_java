package ch08.instructions.loads.lload;

import ch08.instructions.base.instruction.NoOperandsInstruction;
import ch08.instructions.loads.lload._LLOAD;
import ch08.rtda.Frame;
import org.joou.UInteger;

public class LLOAD_0 extends NoOperandsInstruction {
    @Override
    public void Execute(Frame frame) {
        _LLOAD._lload(frame, UInteger.valueOf(0));
    }
}
