package ch08.instructions.constants.ldc;

import ch08.instructions.base.instruction.Index16Instruction;
import ch08.instructions.constants.ldc._LDC;
import ch08.rtda.Frame;

public class LDC_W extends Index16Instruction {

    @Override
    public void Execute(Frame frame) {
        _LDC._ldc(frame,index);
    }
}
