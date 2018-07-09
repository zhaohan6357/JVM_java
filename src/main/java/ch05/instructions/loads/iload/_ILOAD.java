package ch05.instructions.loads.iload;

import ch05.rtda.Frame;
import org.joou.UInteger;

//this is not a instruction
public class _ILOAD {
  /*  func _iload(frame *rtda.Frame, index uint) {
        val := frame.LocalVars().GetInt(index)
        frame.OperandStack().PushInt(val)
    }*/
    public static void _ioad(Frame frame, UInteger index){
        int val=frame.localVars.getInt(index);
        frame.operandStack.pushInt(val);
    }
}
