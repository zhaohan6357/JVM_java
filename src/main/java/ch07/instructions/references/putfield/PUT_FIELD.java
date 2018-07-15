package ch07.instructions.references.putfield;

import ch07.instructions.base.instruction.Index16Instruction;
import ch07.rtda.Frame;
import ch07.rtda.OperandStack;
import ch07.rtda.heap.*;
import ch07.rtda.heap.Class;
import ch07.rtda.heap.Object;
import ch07.rtda.heap.constant_pool.ConstantPool;
import org.joou.UInteger;

public class PUT_FIELD extends Index16Instruction {
    @Override
    public void Execute(Frame frame) {
        Method currentMethod = frame.method;
        Class currentClazz = currentMethod.clazz;
        ConstantPool cp = currentClazz.constantPool;
        FieldRef fieldRef = (FieldRef) cp.getConstant(index).object;
        Field field = fieldRef.ResolvedField();
        if (field.IsStatic()) {
            System.out.println("java.lang.IncompatibleClassChangeError");
        }
        if (field.IsFinal()) {
            if (currentClazz != field.clazz || !currentMethod.name.equals("<clinit>")) {
                System.out.println("java.lang.IllegalAccessError");
            }
        }

        String descriptor = field.descriptor;
        UInteger slotId = field.slotId;
        OperandStack stack=frame.operandStack;
        switch (descriptor.charAt(0)){
            case 'Z': case 'B': case 'C': case 'S': case'I':
                int val=stack.popInt();
                Object ref=stack.popRef();
                if(ref==null){
                    System.out.println("java.lang.NullPointerException");
                }else{
                    ref.fields.setInt(slotId,val);
                }
                return;
            case 'D':
                double dval=stack.popDouble();
                Object dref=stack.popRef();
                if(dref==null){
                    System.out.println("java.lang.NullPointerException");
                }else{
                    dref.fields.setDouble(slotId,dval);
                }
                return;
            case 'F':
                float fval=stack.popFloat();
                Object fref=stack.popRef();
                if(fref==null){
                    System.out.println("java.lang.NullPointerException");
                }else{
                    fref.fields.setFloat(slotId,fval);
                }
                return;
            case 'J':
                long lval=stack.popLong();
                Object lref=stack.popRef();
                if(lref==null){
                    System.out.println("java.lang.NullPointerException");
                }else{
                    lref.fields.setLong(slotId,lval);
                }
                return;
            case 'L': case '[':
                Object aval=stack.popRef();
                Object aref=stack.popRef();
                if(aref==null){
                    System.out.println("java.lang.NullPointerException");
                }else{
                    aref.fields.setRef(slotId,aval);
                }
                return;
            default:
                //todo
        }
    }

/*
        descriptor := field.Descriptor()
        slotId := field.SlotId()
        stack := frame.OperandStack()

        switch descriptor[0] {
            case 'Z', 'B', 'C', 'S', 'I':
                val := stack.PopInt()
                ref := stack.PopRef()
                if ref == nil {
                panic("java.lang.NullPointerException")
            }
            ref.Fields().SetInt(slotId, val)
            case 'F':
                val := stack.PopFloat()
                ref := stack.PopRef()
                if ref == nil {
                panic("java.lang.NullPointerException")
            }
            ref.Fields().SetFloat(slotId, val)
            case 'J':
                val := stack.PopLong()
                ref := stack.PopRef()
                if ref == nil {
                panic("java.lang.NullPointerException")
            }
            ref.Fields().SetLong(slotId, val)
            case 'D':
                val := stack.PopDouble()
                ref := stack.PopRef()
                if ref == nil {
                panic("java.lang.NullPointerException")
            }
            ref.Fields().SetDouble(slotId, val)
            case 'L', '[':
                val := stack.PopRef()
                ref := stack.PopRef()
                if ref == nil {
                panic("java.lang.NullPointerException")
            }
            ref.Fields().SetRef(slotId, val)
            default:
                // todo
        }
    }*/
}
