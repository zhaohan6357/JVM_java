package ch08.instructions.control.goto_;

import ch08.instructions.base.branch_logic.branch_logic;
import ch08.instructions.base.instruction.BranchInstruction;
import ch08.rtda.Frame;

public class GOTO extends BranchInstruction {
    @Override
    public void Execute(Frame frame) {
        branch_logic.Branch(frame,offset);
    }
}
