package ch09.instructions.control.goto_;

import ch09.instructions.base.branch_logic.branch_logic;
import ch09.instructions.base.instruction.BranchInstruction;
import ch09.rtda.Frame;

public class GOTO extends BranchInstruction {
    @Override
    public void Execute(Frame frame) {
        branch_logic.Branch(frame,offset);
    }
}
