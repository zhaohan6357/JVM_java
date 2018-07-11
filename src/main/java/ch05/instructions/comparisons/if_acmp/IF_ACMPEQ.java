package ch05.instructions.comparisons.if_acmp;

import ch05.instructions.base.branch_logic.branch_logic;
import ch05.instructions.base.instruction.BranchInstruction;
import ch05.rtda.Frame;
import ch05.rtda.Object;

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
