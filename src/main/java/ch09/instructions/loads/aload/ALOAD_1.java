package ch09.instructions.loads.aload;

import ch09.instructions.base.instruction.NoOperandsInstruction;
import ch09.instructions.loads.aload._ALOAD;
import ch09.rtda.Frame;
import org.joou.UInteger;

public class ALOAD_1 extends NoOperandsInstruction {
    @Override
    public void Execute(Frame frame) {
        _ALOAD._aload(frame, UInteger.valueOf(1));
    }

}
