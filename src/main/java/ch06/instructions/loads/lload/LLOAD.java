package ch06.instructions.loads.lload;

import ch06.instructions.base.instruction.Index8Instruction;
import ch06.instructions.loads.lload._LLOAD;
import ch06.rtda.Frame;

public class LLOAD extends Index8Instruction {
    @Override
    public void Execute(Frame frame) {
        _LLOAD._lload(frame,index);
    }
}
