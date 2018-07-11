package ch06.instructions.control.goto_;

import ch06.instructions.base.branch_logic.branch_logic;
import ch06.instructions.base.instruction.BranchInstruction;
import ch06.rtda.Frame;

public class GOTO extends BranchInstruction {
    @Override
    public void Execute(Frame frame) {
        branch_logic.Branch(frame,offset);
    }
}
