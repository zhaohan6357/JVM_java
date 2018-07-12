package ch06.rtda.heap;

import ch06.classfile.ConstantValueAttribute;
import ch06.classfile.MemberInfo;
import org.joou.UInteger;

import java.io.File;

public class Field extends ClassMember{
    /*type Field struct {
        ClassMember
        constValueIndex uint
        slotId          uint
    }*/
    UInteger constValueIndex;
    UInteger slotId;

   /* func newFields(class *Class, cfFields []*classfile.MemberInfo) []*Field {
        fields := make([]*Field, len(cfFields))
        for i, cfField := range cfFields {
            fields[i] = &Field{}
            fields[i].class = class
            fields[i].copyMemberInfo(cfField)
            fields[i].copyAttributes(cfField)
        }
        return fields
    }*/
    public static Field[] newFields(Class clazz, MemberInfo[] cfields) {
        Field[] fields=new Field[cfields.length];
        for(int i=0;i<fields.length;i++){
            fields[i]=new Field();
            fields[i].clazz=clazz;
            fields[i].copyMemberInfo(cfields[i]);
            fields[i].copyAttributes(cfields[i]);

        }
        return fields;
    }

    /*func (self *Field) copyAttributes(cfField *classfile.MemberInfo) {
        if valAttr := cfField.ConstantValueAttribute(); valAttr != nil {
            self.constValueIndex = uint(valAttr.ConstantValueIndex())
        }
    }*/
    public void copyAttributes(MemberInfo cfField){
        ConstantValueAttribute valAttr=cfField.ConstantValueAttribute();
        if(valAttr!=null){
            constValueIndex=UInteger.valueOf(valAttr.getConstantValueIndex().intValue());
        }
    }
}