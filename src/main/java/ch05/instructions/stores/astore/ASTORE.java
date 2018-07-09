package ch05.instructions.stores.astore;

import ch05.instructions.base.instruction.Index8Instruction;
import ch05.rtda.Frame;

public class ASTORE extends Index8Instruction{
    @Override
    public void Execute(Frame frame) {
        _ASTORE._astore(frame,index);
    }
}
