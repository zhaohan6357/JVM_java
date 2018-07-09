package ch05.instructions.loads.fload;

import ch05.rtda.Frame;
import org.joou.UInteger;

public class _FLOAD {
   /* func _fload(frame *rtda.Frame, index uint) {
        val := frame.LocalVars().GetFloat(index)
        frame.OperandStack().PushFloat(val)
    }*/
   public static void _fload(Frame frame, UInteger index){
       float val=frame.localVars.getFloat(index);
       frame.operandStack.pushFloat(val);
   }
}
