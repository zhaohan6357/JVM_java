package ch08.instructions.stores.xastore;

import ch08.instructions.base.instruction.NoOperandsInstruction;
import ch08.instructions.loads.xaload.CHECK;
import ch08.rtda.Frame;
import ch08.rtda.OperandStack;
import ch08.rtda.heap.Object;

public class CASTORE extends NoOperandsInstruction {
    @Override
    public void Execute(Frame frame) {
        OperandStack stack=frame.operandStack;
        int ref=stack.popInt();
        int index=stack.popInt();
        Object arrRef=stack.popRef();

        CHECK.checkNotNull(arrRef);
        char[] refs=arrRef.Chars();
        CHECK.checkIndex(refs.length,index);
        refs[index]=(char)ref;
    }
}
