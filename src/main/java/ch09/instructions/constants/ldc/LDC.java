package ch09.instructions.constants.ldc;

import ch09.instructions.base.instruction.Index8Instruction;
import ch09.instructions.constants.ldc._LDC;
import ch09.rtda.Frame;

public class LDC extends Index8Instruction {
    @Override
    public void Execute(Frame frame) {
        _LDC._ldc(frame,index);
    }
}
