package ch08.instructions.loads.lload;

import ch08.instructions.base.instruction.Index8Instruction;
import ch08.instructions.loads.lload._LLOAD;
import ch08.rtda.Frame;

public class LLOAD extends Index8Instruction {
    @Override
    public void Execute(Frame frame) {
        _LLOAD._lload(frame,index);
    }
}
