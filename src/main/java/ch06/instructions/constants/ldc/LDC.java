package ch06.instructions.constants.ldc;

import ch06.instructions.base.instruction.Index8Instruction;
import ch06.rtda.Frame;

public class LDC extends Index8Instruction {
    @Override
    public void Execute(Frame frame) {
        _LDC._ldc(frame,index);
    }
}
