package ch08.instructions.extended.ifnull;

import ch08.instructions.base.branch_logic.branch_logic;
import ch08.instructions.base.instruction.BranchInstruction;
import ch08.rtda.Frame;
import ch08.rtda.heap.Object;

public class IFNONNULL extends BranchInstruction {
    @Override
    public void Execute(Frame frame) {
        Object ref=frame.operandStack.popRef();
        if(ref!=null){
            branch_logic.Branch(frame,offset);
        }
    }
}
