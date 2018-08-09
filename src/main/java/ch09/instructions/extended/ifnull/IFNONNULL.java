package ch09.instructions.extended.ifnull;

import ch09.instructions.base.branch_logic.branch_logic;
import ch09.instructions.base.instruction.BranchInstruction;
import ch09.rtda.Frame;
import ch09.rtda.heap.Object;

public class IFNONNULL extends BranchInstruction {
    @Override
    public void Execute(Frame frame) {
        Object ref=frame.operandStack.popRef();
        if(ref!=null){
            branch_logic.Branch(frame,offset);
        }
    }
}
