package ch09.instructions.loads.lload;

import ch09.instructions.base.instruction.Index8Instruction;
import ch09.instructions.loads.lload._LLOAD;
import ch09.rtda.Frame;

public class LLOAD extends Index8Instruction {
    @Override
    public void Execute(Frame frame) {
        _LLOAD._lload(frame,index);
    }
}
