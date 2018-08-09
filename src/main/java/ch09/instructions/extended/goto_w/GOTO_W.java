package ch09.instructions.extended.goto_w;

import ch09.instructions.base.ByteCodeReader;
import ch09.instructions.base.branch_logic.branch_logic;
import ch09.instructions.base.instruction.BranchInstruction;
import ch09.rtda.Frame;

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
