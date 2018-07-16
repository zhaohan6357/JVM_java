package ch08.instructions.stores.astore;

import ch08.instructions.base.instruction.Index8Instruction;
import ch08.instructions.stores.astore._ASTORE;
import ch08.rtda.Frame;

public class ASTORE extends Index8Instruction{
    @Override
    public void Execute(Frame frame) {
        _ASTORE._astore(frame,index);
    }
}
