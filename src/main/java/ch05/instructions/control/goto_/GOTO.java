package ch05.instructions.control.goto_;

import ch05.instructions.base.branch_logic.branch_logic;
import ch05.instructions.base.instruction.BranchInstruction;
import ch05.rtda.Frame;

public class GOTO extends BranchInstruction {
    @Override
    public void Execute(Frame frame) {
        branch_logic.Branch(frame,offset);
    }
}
