package ch05.instructions.loads.aload;

import ch05.instructions.base.instruction.NoOperandsInstruction;
import ch05.rtda.Frame;
import org.joou.UInteger;

public class ALOAD_0 extends NoOperandsInstruction {
    @Override
    public void Execute(Frame frame) {
        _ALOAD._aload(frame, UInteger.valueOf(0));
    }
}
