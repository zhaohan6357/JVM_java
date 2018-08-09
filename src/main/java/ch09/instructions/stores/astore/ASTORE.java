package ch09.instructions.stores.astore;

import ch09.instructions.base.instruction.Index8Instruction;
import ch09.instructions.stores.astore._ASTORE;
import ch09.rtda.Frame;

public class ASTORE extends Index8Instruction{
    @Override
    public void Execute(Frame frame) {
        _ASTORE._astore(frame,index);
    }
}
