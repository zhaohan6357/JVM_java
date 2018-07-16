package ch08.instructions.references.getfield;

import ch08.instructions.base.instruction.Index16Instruction;
import ch08.rtda.Frame;
import ch08.rtda.OperandStack;
import ch08.rtda.heap.Field;
import ch08.rtda.heap.FieldRef;
import ch08.rtda.heap.Object;
import ch08.rtda.heap.Slots;
import ch08.rtda.heap.constant_pool.ConstantPool;
import org.joou.UInteger;

public class GET_FIELD extends Index16Instruction{
    @Override
    public void Execute(Frame frame) {
        ConstantPool cp=frame.method.clazz.constantPool;
        FieldRef fieldRef = (FieldRef) cp.getConstant(index).object;
        Field field = fieldRef.ResolvedField();
        if (field.IsStatic()) {
            System.out.println("java.lang.IncompatibleClassChangeError");
        }
        OperandStack stack=frame.operandStack;
        Object ref=stack.popRef();
        if(ref==null){
            System.out.println("java.lang.NullPointerException");
            return;
        }
        String descriptor = field.descriptor;
        UInteger slotId = field.slotId;
        Slots slots=ref.fields();
        switch (descriptor.charAt(0)){
            case 'Z': case 'B': case 'C': case 'S': case'I':
                stack.pushInt(slots.getInt(slotId));
                return;
            case 'F':
                stack.pushFloat(slots.getFloat(slotId));
                return;
            case 'D':
                stack.pushDouble(slots.getDouble(slotId));
                return;
            case 'J':
                stack.pushLong(slots.getLong(slotId));
                return;
            case 'L': case '[':
                stack.pushRef(slots.getRef(slotId));
                return;
            default:
                //todo
        }






    }
}
