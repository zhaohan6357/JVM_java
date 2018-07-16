package ch08.instructions.stores.dstore;

import ch08.rtda.Frame;
import org.joou.UInteger;

public class _DSTORE {
    /*func _dstore(frame *rtda.Frame, index uint) {
        val := frame.OperandStack().PopDouble()
        frame.LocalVars().SetDouble(index, val)
    }*/
    public static void _dstore(Frame frame, UInteger index){
        double val=frame.operandStack.popDouble();
        frame.localVars.setDouble(index,val);
    }
}
