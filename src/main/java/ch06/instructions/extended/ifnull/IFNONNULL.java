package ch06.instructions.extended.ifnull;

import ch06.instructions.base.branch_logic.branch_logic;
import ch06.instructions.base.instruction.BranchInstruction;
import ch06.rtda.Frame;
import ch06.rtda.Object;

public class IFNONNULL extends BranchInstruction {
    @Override
    public void Execute(Frame frame) {
        Object ref=frame.operandStack.popRef();
        if(ref!=null){
            branch_logic.Branch(frame,offset);
        }
    }
}
