package ch07.instructions.loads.aload;

import ch07.instructions.base.instruction.NoOperandsInstruction;
import ch07.instructions.loads.aload._ALOAD;
import ch07.rtda.Frame;
import org.joou.UInteger;

public class ALOAD_3 extends NoOperandsInstruction {
    @Override
    public void Execute(Frame frame) {
        _ALOAD._aload(frame, UInteger.valueOf(3));
    }
}
