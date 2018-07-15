package ch07.instructions.comparisons.if_acmp;

import ch07.instructions.base.branch_logic.branch_logic;
import ch07.instructions.base.instruction.BranchInstruction;
import ch07.rtda.Frame;
import ch07.rtda.heap.Object;

public class IF_ACMPNE extends BranchInstruction {

    @Override
    public void Execute(Frame frame) {
        Object obj1=frame.operandStack.popRef();
        Object obj2=frame.operandStack.popRef();
        if(obj1!=obj2){
            branch_logic.Branch(frame,offset);
        }

    }
}
