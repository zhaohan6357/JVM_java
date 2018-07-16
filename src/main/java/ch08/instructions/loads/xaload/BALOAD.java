package ch08.instructions.loads.xaload;

import ch08.instructions.base.instruction.NoOperandsInstruction;
import ch08.rtda.Frame;
import ch08.rtda.OperandStack;
import ch08.rtda.heap.Object;

public class BALOAD extends NoOperandsInstruction{
    @Override
    public void Execute(Frame frame) {
        OperandStack stack=frame.operandStack;
        int index=stack.popInt();
        Object arrRef=stack.popRef();

        CHECK.checkNotNull(arrRef);
        byte[] refs=arrRef.Bytes();
        CHECK.checkIndex(refs.length,index);
        stack.pushInt((int)(refs[index]));
    }
}
