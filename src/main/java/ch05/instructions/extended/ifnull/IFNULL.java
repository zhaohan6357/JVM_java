package ch05.instructions.extended.ifnull;

import ch05.instructions.base.branch_logic.branch_logic;
import ch05.instructions.base.instruction.BranchInstruction;
import ch05.rtda.Frame;
import ch05.rtda.Object;

public class IFNULL extends BranchInstruction {
    /*Type IFNULL struct{ base.BranchInstruction }

    func (self *IFNULL) Execute(frame *rtda.Frame) {
        ref := frame.OperandStack().PopRef()
        if ref == nil {
            base.Branch(frame, self.Offset)
        }
    }*/
    @Override
    public void Execute(Frame frame) {
        Object ref=frame.operandStack.popRef();
        if(ref==null){
            branch_logic.Branch(frame,offset);
        }
    }
}
