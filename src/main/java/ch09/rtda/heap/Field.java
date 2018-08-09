package ch09.rtda.heap;

import ch09.classfile.ConstantValueAttribute;
import ch09.classfile.MemberInfo;
import ch09.rtda.heap.Access_flags;
import ch09.rtda.heap.Class;
import ch09.rtda.heap.ClassMember;
import org.joou.UInteger;

public class Field extends ClassMember {

    public UInteger constValueIndex = UInteger.valueOf(0);//
    public UInteger slotId = UInteger.valueOf(0);;

    public static Field[] newFields(Class clazz, MemberInfo[] cfields) {
        Field[] fields = new Field[cfields.length];
        for (int i = 0; i < fields.length; i++) {
            fields[i] = new Field();
            fields[i].clazz = clazz;
            fields[i].copyMemberInfo(cfields[i]);
            fields[i].copyAttributes(cfields[i]);

        }
        return fields;
    }

    public void copyAttributes(MemberInfo cfField) {
        ConstantValueAttribute valAttr = cfField.ConstantValueAttribute();
        if (valAttr != null) {
            constValueIndex = UInteger.valueOf(valAttr.getConstantValueIndex().intValue());
        }
    }

    public boolean isLongOrDouble() {
        return descriptor.equals("J") || descriptor.equals("D");
    }

    public boolean isVolatile() {
        return 0 != (accessFlags.intValue() & (Access_flags.ACC_VOLATILE));
    }

    public boolean isTransient() {
        return 0 != (accessFlags.intValue() & (Access_flags.ACC_TRANSIENT));
    }

    public boolean isEnum() {
        return 0 != (accessFlags.intValue() & (Access_flags.ACC_ENUM));
    }
}