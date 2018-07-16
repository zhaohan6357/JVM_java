package ch08.instructions.constants.ldc;

import ch08.instructions.base.instruction.Index8Instruction;
import ch08.instructions.constants.ldc._LDC;
import ch08.rtda.Frame;

public class LDC extends Index8Instruction {
    @Override
    public void Execute(Frame frame) {
        _LDC._ldc(frame,index);
    }
}
