package ch07.instructions.extended.goto_w;

import ch07.instructions.base.ByteCodeReader;
import ch07.instructions.base.branch_logic.branch_logic;
import ch07.instructions.base.instruction.BranchInstruction;
import ch07.rtda.Frame;

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
