package ch07.instructions.loads.lload;

import ch07.instructions.base.instruction.Index8Instruction;
import ch07.instructions.loads.lload._LLOAD;
import ch07.rtda.Frame;

public class LLOAD extends Index8Instruction {
    @Override
    public void Execute(Frame frame) {
        _LLOAD._lload(frame,index);
    }
}
