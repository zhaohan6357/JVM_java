package ch06.instructions.stores.lscore;

import ch06.rtda.Frame;
import org.joou.UInteger;

public class _LSTORE {
    /*func _lstore(frame *rtda.Frame, index uint) {
        val := frame.OperandStack().PopLong()
        frame.LocalVars().SetLong(index, val)
    }*/
    public static void _lstore(Frame frame, UInteger index){
        long val=frame.operandStack.popLong();
        frame.localVars.setLong(index,val);
    }

}
