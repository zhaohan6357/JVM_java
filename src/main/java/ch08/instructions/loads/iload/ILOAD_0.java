package ch08.instructions.loads.iload;

import ch08.instructions.loads.iload._ILOAD;
import ch08.rtda.Frame;
import ch08.instructions.base.instruction.NoOperandsInstruction;
import org.joou.UInteger;

public class ILOAD_0 extends NoOperandsInstruction {

/*    type ILOAD_0 struct{ base.NoOperandsInstruction }

    func (self *ILOAD_0) Execute(frame *rtda.Frame) {
        _iload(frame, 0)
    }*/

    @Override
    public void Execute(Frame frame) {
        _ILOAD._ioad(frame, UInteger.valueOf(0));
    }
}
