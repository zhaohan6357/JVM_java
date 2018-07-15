package ch07.instructions.references.getstatic;

import ch07.instructions.base.class_init_logic.InitClass;
import ch07.instructions.base.instruction.Index16Instruction;
import ch07.rtda.Frame;
import ch07.rtda.OperandStack;
import ch07.rtda.heap.Class;
import ch07.rtda.heap.Field;
import ch07.rtda.heap.FieldRef;
import ch07.rtda.heap.Slots;
import ch07.rtda.heap.constant_pool.ConstantPool;
import org.joou.UInteger;

public class GET_STATIC extends Index16Instruction {
    @Override
    public void Execute(Frame frame) {
        ConstantPool cp=frame.method.clazz.constantPool;
        FieldRef fieldRef = (FieldRef) cp.getConstant(index).object;
        Field field = fieldRef.ResolvedField();
        Class clazz = field.clazz;

        if(!clazz.initStarted){
            frame.revertNextPC();
            InitClass.InitClass(frame.thread,clazz);
            return;
        }
        if (!field.IsStatic()) {
            System.out.println("java.lang.IncompatibleClassChangeError");
        }

        String descriptor = field.descriptor;
        UInteger slotId = field.slotId;
        Slots slots=clazz.staticVars;
        OperandStack stack=frame.operandStack;

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
