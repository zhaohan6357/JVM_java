package ch08.instructions.stores.xastore;

import ch08.instructions.base.instruction.NoOperandsInstruction;
import ch08.instructions.loads.xaload.CHECK;
import ch08.rtda.Frame;
import ch08.rtda.OperandStack;
import ch08.rtda.heap.Object;

public class LASOTRE extends NoOperandsInstruction {
    @Override
    public void Execute(Frame frame) {
        OperandStack stack=frame.operandStack;
        long ref=stack.popLong();
        int index=stack.popInt();
        Object arrRef=stack.popRef();

        CHECK.checkNotNull(arrRef);
        long[] refs=arrRef.Longs();
        CHECK.checkIndex(refs.length,index);
        refs[index]=ref;
    }
}
