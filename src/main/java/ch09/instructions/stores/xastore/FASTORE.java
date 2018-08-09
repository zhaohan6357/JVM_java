package ch09.instructions.stores.xastore;

import ch09.instructions.base.instruction.NoOperandsInstruction;
import ch09.instructions.loads.xaload.CHECK;
import ch09.rtda.Frame;
import ch09.rtda.OperandStack;
import ch09.rtda.heap.Object;

public class FASTORE extends NoOperandsInstruction {
    @Override
    public void Execute(Frame frame) {
        OperandStack stack=frame.operandStack;
        float ref=stack.popFloat();
        int index=stack.popInt();
        Object arrRef=stack.popRef();

        CHECK.checkNotNull(arrRef);
        float[] refs=arrRef.Floats();
        CHECK.checkIndex(refs.length,index);
        refs[index]=ref;
    }
}
