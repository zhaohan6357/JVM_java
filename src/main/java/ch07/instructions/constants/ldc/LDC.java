package ch07.instructions.constants.ldc;

import ch07.instructions.base.instruction.Index8Instruction;
import ch07.instructions.constants.ldc._LDC;
import ch07.rtda.Frame;

public class LDC extends Index8Instruction {
    @Override
    public void Execute(Frame frame) {
        _LDC._ldc(frame,index);
    }
}
