package ch06.instructions.loads.aload;

import ch06.rtda.Frame;
import ch06.rtda.heap.Object;
import org.joou.UInteger;

public class _ALOAD {

    /*func _aload(frame *rtda.Frame, index uint) {
        ref := frame.LocalVars().GetRef(index)
        frame.OperandStack().PushRef(ref)
    }*/
    public static void _aload(Frame frame, UInteger index){
        Object ref=frame.localVars.getRef(index);
        frame.operandStack.pushRef(ref);
    }

}
