package ch09.instructions.loads.dload;

import ch09.rtda.Frame;
import org.joou.UInteger;

public class _DLOAD {
    /*func _dload(frame *rtda.Frame, index uint) {
        val := frame.LocalVars().GetDouble(index)
        frame.OperandStack().PushDouble(val)
    }*/
    public static void _dload(Frame frame, UInteger index){
        double val=frame.localVars.getDouble(index);
        frame.operandStack.pushDouble(val);
    }
}
