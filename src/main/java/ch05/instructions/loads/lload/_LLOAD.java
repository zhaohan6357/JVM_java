package ch05.instructions.loads.lload;

import ch05.rtda.Frame;
import org.joou.UInteger;

public class _LLOAD {

   /* func _lload(frame *rtda.Frame, index uint) {
        val := frame.LocalVars().GetLong(index)
        frame.OperandStack().PushLong(val)
    }*/
   public static void _lload(Frame frame, UInteger index){
       long val=frame.localVars.getLong(index);
       frame.operandStack.pushLong(val);
   }
}
