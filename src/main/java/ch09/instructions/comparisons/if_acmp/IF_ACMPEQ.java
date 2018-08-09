package ch09.instructions.comparisons.if_acmp;

import ch09.instructions.base.branch_logic.branch_logic;
import ch09.instructions.base.instruction.BranchInstruction;
import ch09.rtda.Frame;
import ch09.rtda.heap.Object;

public class IF_ACMPEQ extends BranchInstruction {

    @Override
    public void Execute(Frame frame) {
        Object obj1=frame.operandStack.popRef();
        Object obj2=frame.operandStack.popRef();
        if(obj1==obj2){
            branch_logic.Branch(frame,offset);
        }

    }
}
