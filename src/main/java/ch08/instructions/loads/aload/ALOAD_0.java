package ch08.instructions.loads.aload;

import ch08.instructions.base.instruction.NoOperandsInstruction;
import ch08.instructions.loads.aload._ALOAD;
import ch08.rtda.Frame;
import org.joou.UInteger;

public class ALOAD_0 extends NoOperandsInstruction {
    @Override
    public void Execute(Frame frame) {
        _ALOAD._aload(frame, UInteger.valueOf(0));
    }
}
