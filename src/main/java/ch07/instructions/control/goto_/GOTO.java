package ch07.instructions.control.goto_;

import ch07.instructions.base.branch_logic.branch_logic;
import ch07.instructions.base.instruction.BranchInstruction;
import ch07.rtda.Frame;

public class GOTO extends BranchInstruction {
    @Override
    public void Execute(Frame frame) {
        branch_logic.Branch(frame,offset);
    }
}
