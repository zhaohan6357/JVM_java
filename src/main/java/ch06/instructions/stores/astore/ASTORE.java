package ch06.instructions.stores.astore;

import ch06.instructions.base.instruction.Index8Instruction;
import ch06.instructions.stores.astore._ASTORE;
import ch06.rtda.Frame;

public class ASTORE extends Index8Instruction{
    @Override
    public void Execute(Frame frame) {
        _ASTORE._astore(frame,index);
    }
}
