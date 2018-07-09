package ch05.instructions.loads.lload;

import ch05.instructions.base.instruction.Index8Instruction;
import ch05.rtda.Frame;

public class LLOAD extends Index8Instruction {
    @Override
    public void Execute(Frame frame) {
        _LLOAD._lload(frame,index);
    }
}
