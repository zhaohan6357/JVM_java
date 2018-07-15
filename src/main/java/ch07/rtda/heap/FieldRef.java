package ch07.rtda.heap;

import ch07.classfile.ConstantFieldrefInfo;
import ch07.rtda.heap.constant_pool.ConstantPool;

public class FieldRef extends MemberRef {
    /* type FieldRef struct {
         MemberRef
         field *Field
     }

     func newFieldRef(cp *ConstantPool, refInfo *classfile.ConstantFieldrefInfo) *FieldRef {
         ref := &FieldRef{}
         ref.cp = cp
         ref.copyMemberRefInfo(&refInfo.ConstantMemberrefInfo)
         return ref
     }*/
    ch07.rtda.heap.Field field;

    public static FieldRef newFieldRef(ConstantPool cp, ConstantFieldrefInfo refInfo) {
        FieldRef ref = new FieldRef();
        ref.cp = cp;
        // ConstantMemberrefInfo constantMemberrefInfo=(ConstantMemberrefInfo)refInfo;
        ref.copyMemberRefInfo(refInfo);
        return ref;
    }

/*
    func (self *FieldRef) ResolvedField() *Field {
        if self.field == nil {
            self.resolveFieldRef()
        }
        return self.field
    }
*/
    public ch07.rtda.heap.Field ResolvedField(){
        if(field==null){
          resolveFieldRef();
        }
        return field;
    }

    public void resolveFieldRef(){
        ch07.rtda.heap.Class d=cp.clazz;
        ch07.rtda.heap.Class c=ResolvedClass();
        ch07.rtda.heap.Field field=lookupField(c,name,descriptor);
        if(field==null){
            System.out.println("java.lang.NoSuchFieldError");
        }
        this.field=field;

    }
    /*func (self *FieldRef) resolveFieldRef() {
        d := self.cp.class
        c := self.ResolvedClass()
        field := lookupField(c, self.name, self.descriptor)

        if field == nil {
            panic("java.lang.NoSuchFieldError")
        }
        if !field.isAccessibleTo(d) {
            panic("java.lang.IllegalAccessError")
        }

        self.field = field
    }*/

    /*func lookupField(c *Class, name, descriptor string) *Field {
        for _, field := range c.fields {
            if field.name == name && field.descriptor == descriptor {
                return field
            }
        }
        for _, iface := range c.interfaces {
            if field := lookupField(iface, name, descriptor); field != nil {
                return field
            }
        }
        if c.superClass != nil {
            return lookupField(c.superClass, name, descriptor)
        }
    }*/
    public ch07.rtda.heap.Field lookupField(ch07.rtda.heap.Class c, String name, String decriptor){
        for(ch07.rtda.heap.Field field:c.fields){
            if(field.name.equals(name)&&field.descriptor.equals(decriptor)){
                return field;
            }
        }
        for(Class interfaces:c.interfaces){
            Field field=lookupField(interfaces,name,decriptor);
            if(field!=null){
                return field;
            }
        }
        if(c.superClass!=null){
            return lookupField(c.superClass,name,decriptor);
        }
        return null;
    }


}
