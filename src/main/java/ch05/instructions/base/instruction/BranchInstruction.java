package ch05.instructions.base.instruction;


import ch05.instructions.base.ByteCodeReader;

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
