package ch06.instructions.constants.ldc;

import ch06.instructions.base.instruction.Index16Instruction;
import ch06.rtda.Frame;

public class LDC_W extends Index16Instruction {

    @Override
    public void Execute(Frame frame) {
        _LDC._ldc(frame,index);
    }
}
