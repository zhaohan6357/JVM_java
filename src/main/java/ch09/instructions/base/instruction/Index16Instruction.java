package ch09.instructions.base.instruction;

import ch09.instructions.base.ByteCodeReader;
import ch09.instructions.base.instruction.Instruction;
import org.joou.UInteger;

public class Index16Instruction extends Instruction {

 /*   func (self *Index16Instruction) FetchOperands(reader *BytecodeReader) {
        self.Index = uint(reader.ReadUint16())
    }*/
    @Override
    public void FetchOperands(ByteCodeReader reader) {
        int i=reader.readUInt16().intValue();
        index=UInteger.valueOf(i);
    }
}
