package ch06.rtda.heap;

import ch06.classfile.MemberInfo;
import org.joou.UShort;

public class ClassMember {
    /* type ClassMember struct {
         accessFlags uint16
         name        string
         descriptor  string
         class       *Class
     }*/
    public UShort accessFlags;
    public String name;
    public String descriptor;
    public Class clazz;
 /*   public boolean copyMemberInfo(memberInfo *classfile.MemberInfo) {
        (accessFlags.intValue() Access_flags.= memberInfo.AccessFlags()
        self.name = memberInfo.Name()
        self.descriptor = memberInfo.Descriptor()
    }*/
    public void copyMemberInfo(MemberInfo memberInfo){
        accessFlags=memberInfo.getAccessFlag();
        name=memberInfo.name();
        descriptor=memberInfo.descripter();
    }

    public boolean IsPublic()  {
        return 0 != (accessFlags.intValue()&Access_flags.ACC_PUBLIC);
    }
    public boolean IsPrivate()  {
        return 0 != (accessFlags.intValue()&Access_flags.ACC_PRIVATE);
    }
    public boolean IsProtected()  {
        return 0 != (accessFlags.intValue()&Access_flags.ACC_PROTECTED);
    }
    public boolean IsStatic()  {
        return 0 != (accessFlags.intValue()&Access_flags.ACC_STATIC);
    }
    public boolean IsFinal()  {
        return 0 != (accessFlags.intValue()&Access_flags.ACC_FINAL);
    }
    public boolean IsSynthetic()  {
        return 0 != (accessFlags.intValue()&Access_flags.ACC_SYNTHETIC);
    }

   /* func (self *ClassMember) isAccessibleTo(d *Class) bool {
        if self.IsPublic() {
            return true
        }
        c := self.class
        if self.IsProtected() {
            return d == c || d.isSubClassOf(c) ||
                    c.getPackageName() == d.getPackageName()
        }
        if !self.IsPrivate() {
            return c.getPackageName() == d.getPackageName()
        }
        return d == c
    }*/

   public boolean isAccessibleTo(Class d){
       if(IsPublic()){
           return true;
       }
       Class c=clazz;
       if(IsProtected()){
           return d==c||d.isSubClassOf(c)||c.getPackageName().equals(d.getPackageName());
       }
       if(!IsPrivate()){
           return c.getPackageName().equals(d.getPackageName());
       }
       return d==c;//todo 此处或许应比较name 字符串
   }



}
