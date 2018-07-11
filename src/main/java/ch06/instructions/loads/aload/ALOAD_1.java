package ch06.instructions.loads.aload;

import ch06.instructions.base.instruction.NoOperandsInstruction;
import ch06.instructions.loads.aload._ALOAD;
import ch06.rtda.Frame;
import org.joou.UInteger;

public class ALOAD_1 extends NoOperandsInstruction {
    @Override
    public void Execute(Frame frame) {
        _ALOAD._aload(frame, UInteger.valueOf(1));
    }

}
