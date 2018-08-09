package ch09.instructions.base.instruction;


import ch09.instructions.base.ByteCodeReader;
import ch09.instructions.base.instruction.Instruction;

public class BranchInstruction extends Instruction{
/*    type BranchInstruction struct {
        Offset int
    }*/


/*    func (self *BranchInstruction) FetchOperands(reader *BytecodeReader) {
        self.Offset = int(reader.ReadInt16())
    }*/
    @Override
    public void FetchOperands(ByteCodeReader reader) {
        offset=(int)reader.readInt16();
    }
}
