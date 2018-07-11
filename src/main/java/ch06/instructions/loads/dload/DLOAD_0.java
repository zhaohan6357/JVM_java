package ch06.instructions.loads.dload;

import ch06.instructions.base.instruction.NoOperandsInstruction;
import ch06.instructions.loads.dload._DLOAD;
import ch06.rtda.Frame;
import org.joou.UInteger;

public class DLOAD_0 extends NoOperandsInstruction {
/*    type DLOAD_0 struct{ base.NoOperandsInstruction }

    func (self *DLOAD_0) Execute(frame *rtda.Frame) {
        _dload(frame, 0)
    }*/

    @Override
    public void Execute(Frame frame) {
        _DLOAD._dload(frame, UInteger.valueOf(0));
    }
}
