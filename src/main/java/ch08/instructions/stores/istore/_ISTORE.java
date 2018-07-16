package ch08.instructions.stores.istore;

import ch08.rtda.Frame;
import org.joou.UInteger;

public class _ISTORE {
    /*func _istore(frame *rtda.Frame, index uint) {
        val := frame.OperandStack().PopInt()
        frame.LocalVars().SetInt(index, val)
    }*/
    public static void _istore(Frame frame, UInteger index){
        int val=frame.operandStack.popInt();
        frame.localVars.setInt(index,val);
    }
}
