package ch08.instructions.references.putstatic;

import ch08.instructions.base.class_init_logic.InitClass;
import ch08.instructions.base.instruction.Index16Instruction;
import ch08.rtda.Frame;
import ch08.rtda.OperandStack;
import ch08.rtda.heap.*;
import ch08.rtda.heap.Class;
import ch08.rtda.heap.constant_pool.ConstantPool;
import org.joou.UInteger;

public class PUT_STATIC extends Index16Instruction {
    @Override
    public void Execute(Frame frame) {
        Method currentMethod = frame.method;
        Class currentClazz = currentMethod.clazz;
        ConstantPool cp = currentClazz.constantPool;
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
        if (field.IsFinal()) {
            if (currentClazz != clazz || !currentMethod.name.equals("<clinit>")) {
                System.out.println("java.lang.IllegalAccessError");
            }
        }
        String descriptor = field.descriptor;
        UInteger slotId = field.slotId;
        Slots slots=clazz.staticVars;
        OperandStack stack=frame.operandStack;
        switch (descriptor.charAt(0)){
            case 'Z': case 'B': case 'C': case 'S': case'I':
                slots.setInt(slotId,stack.popInt());
                return;
            case 'F':
                slots.setFloat(slotId,stack.popFloat());
                return;
            case 'D':
                slots.setDouble(slotId,stack.popDouble());
                return;
            case 'J':
                slots.setLong(slotId,stack.popLong());
                return;
            case 'L': case '[':
                slots.setRef(slotId,stack.popRef());
                return;
             default:
                 //todo
        }
    }
}
