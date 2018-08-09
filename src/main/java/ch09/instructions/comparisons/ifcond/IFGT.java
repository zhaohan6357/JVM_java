package ch09.instructions.comparisons.ifcond;

import ch09.instructions.base.branch_logic.branch_logic;
import ch09.instructions.base.instruction.BranchInstruction;
import ch09.rtda.Frame;

public class IFGT extends BranchInstruction {

/*    type IFEQ struct{ base.BranchInstruction }

    func (self *IFEQ) Execute(frame *rtda.Frame) {
        val := frame.OperandStack().PopInt()
        if val == 0 {
            base.Branch(frame, self.Offset)
        }
    }*/

    @Override
    public void Execute(Frame frame) {
        int val=frame.operandStack.popInt();
        if(val>0) {
            branch_logic.Branch(frame, offset);
        }
    }
}
