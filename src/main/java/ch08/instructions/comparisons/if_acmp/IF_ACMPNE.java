package ch08.instructions.comparisons.if_acmp;

import ch08.instructions.base.branch_logic.branch_logic;
import ch08.instructions.base.instruction.BranchInstruction;
import ch08.rtda.Frame;
import ch08.rtda.heap.Object;

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
