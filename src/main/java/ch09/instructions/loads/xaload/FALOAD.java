package ch09.instructions.loads.xaload;

import ch09.instructions.base.instruction.NoOperandsInstruction;
import ch09.instructions.loads.xaload.CHECK;
import ch09.rtda.Frame;
import ch09.rtda.OperandStack;
import ch09.rtda.heap.Object;

public class FALOAD extends NoOperandsInstruction {
    @Override
    public void Execute(Frame frame) {
        OperandStack stack=frame.operandStack;
        int index=stack.popInt();
        Object arrRef=stack.popRef();
        ch09.instructions.loads.xaload.CHECK.checkNotNull(arrRef);
        float[] refs=arrRef.Floats();
        CHECK.checkIndex(refs.length,index);
        stack.pushFloat(refs[index]);
    }
}
