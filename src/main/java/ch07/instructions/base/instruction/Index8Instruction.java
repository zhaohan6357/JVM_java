package ch07.instructions.base.instruction;

import ch07.instructions.base.ByteCodeReader;
import ch07.instructions.base.instruction.Instruction;
import org.joou.UInteger;

public class Index8Instruction extends Instruction {
   /* type Index8Instruction struct {
        Index uint
    }*/


/*    func (self *Index8Instruction) FetchOperands(reader *BytecodeReader) {
        self.Index = uint(reader.ReadUint8())
    }*/
    @Override
    public void FetchOperands(ByteCodeReader reader) {
        int i=reader.readUint8().intValue();
        index=UInteger.valueOf(i);
    }
}
