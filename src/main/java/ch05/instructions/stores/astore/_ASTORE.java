package ch05.instructions.stores.astore;

import ch05.rtda.Frame;
import ch05.rtda.Object;
import org.joou.UInteger;

public class _ASTORE {
   /* func _astore(frame *rtda.Frame, index uint) {
        ref := frame.OperandStack().PopRef()
        frame.LocalVars().SetRef(index, ref)
    }*/
   public static void _astore(Frame frame, UInteger index){
       Object ref=frame.operandStack.popRef();
       frame.localVars.setRef(index,ref);
   }
}
