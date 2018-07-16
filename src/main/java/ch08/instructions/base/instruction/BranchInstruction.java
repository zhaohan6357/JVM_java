package ch08.instructions.base.instruction;


import ch08.instructions.base.ByteCodeReader;
import ch08.instructions.base.instruction.Instruction;

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
