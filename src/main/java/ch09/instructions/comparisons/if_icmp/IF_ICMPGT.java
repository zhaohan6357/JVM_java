package ch09.instructions.comparisons.if_icmp;

import ch09.instructions.base.branch_logic.branch_logic;
import ch09.instructions.base.instruction.BranchInstruction;
import ch09.rtda.Frame;

public class IF_ICMPGT extends BranchInstruction {

/*    // Branch if int comparison succeeds
    type IF_ICMPEQ struct{ base.BranchInstruction }

    func (self *IF_ICMPEQ) Execute(frame *rtda.Frame) {
        if val1, val2 := _icmpPop(frame); val1 == val2 {
            base.Branch(frame, self.Offset)
        }
    }*/
    @Override
    public void Execute(Frame frame) {
        int v2=frame.operandStack.popInt();
        int v1=frame.operandStack.popInt();
        if(v1>v2){
            branch_logic.Branch(frame,offset);
        }
    }
}
