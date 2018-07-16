package ch08.instructions.stores.fstore;

import ch08.rtda.Frame;
import org.joou.UInteger;

public class _FSTORE {
    /*func _fstore(frame *rtda.Frame, index uint) {
        val := frame.OperandStack().PopFloat()
        frame.LocalVars().SetFloat(index, val)
    }*/
    public static void _fstore(Frame frame, UInteger index){
        float val=frame.operandStack.popFloat();
        frame.localVars.setFloat(index,val);
    }
}
