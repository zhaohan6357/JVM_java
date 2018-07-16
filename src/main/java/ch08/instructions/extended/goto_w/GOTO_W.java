package ch08.instructions.extended.goto_w;

import ch08.instructions.base.ByteCodeReader;
import ch08.instructions.base.branch_logic.branch_logic;
import ch08.instructions.base.instruction.BranchInstruction;
import ch08.rtda.Frame;

public class GOTO_W extends BranchInstruction {

    @Override
    public void FetchOperands(ByteCodeReader reader) {
        offset=reader.readInt32();
    }

    @Override
    public void Execute(Frame frame) {
        branch_logic.Branch(frame,offset);
    }

}
