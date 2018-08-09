package ch09.instructions.constants.ldc;

import ch09.instructions.base.instruction.Index16Instruction;
import ch09.instructions.constants.ldc._LDC;
import ch09.rtda.Frame;

public class LDC_W extends Index16Instruction {

    @Override
    public void Execute(Frame frame) {
        _LDC._ldc(frame,index);
    }
}
