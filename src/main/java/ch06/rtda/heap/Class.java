package ch06.rtda.heap;

import ch06.classfile.ClassFile;
import ch06.rtda.heap.constant_pool.ConstantPool;
import org.joou.UInteger;
import org.joou.UShort;


public class Class {
    /* type Class struct {
         accessFlags       uint16
         name              string // thisClassName
         superClassName    string
         interfaceNames    []string
         constantPool      *ConstantPool
         fields            []*Field
         methods           []*Method
         loader            *ClassLoader
         superClass        *Class
         interfaces        []*Class
         instanceSlotCount uint
         staticSlotCount   uint
         staticVars        Slots
     }*/
    public UShort accessFlags;
    public String name;
    public String superClassName;
    public String[] interfaceNames;
    public ConstantPool constantPool;
    public Field[] fields;
    public Method[] methods;
    public ClassLoader loader;
    public Class superClass;
    public Class[] interfaces;
    public UInteger instanceSlotCount;
    public UInteger staticSlotCount;
    public Slots staticVars;

    /*   func newClass(cf *classfile.ClassFile) *Class {
           class := &Class{}
           class.accessFlags = cf.AccessFlags()
           class.name = cf.ClassName()
           class.superClassName = cf.SuperClassName()
           class.interfaceNames = cf.InterfaceNames()
           class.constantPool = newConstantPool(class, cf.ConstantPool())
           class.fields = newFields(class, cf.Fields())
           class.methods = newMethods(class, cf.Methods())
           return class
       }*/
    public static Class newClass(ClassFile cf) {
        Class clazz = new Class();
        clazz.accessFlags = cf.getAccesFlags();
        clazz.name = cf.className();
        clazz.superClassName = cf.superClassName();
        clazz.interfaceNames = cf.interfaceNames();
        clazz.constantPool = ConstantPool.newConstantPool(clazz, cf.getConstantPool());
        clazz.fields = Field.newFields(clazz, cf.getFields());
        clazz.methods = Method.newMethods(clazz, cf.getMethods());
        return clazz;
    }

    public boolean IsPublic() {
        return 0 != (accessFlags.intValue() & Access_flags.ACC_PUBLIC);
    }

    public boolean IsFinal() {
        return 0 != (accessFlags.intValue() & Access_flags.ACC_FINAL);
    }

    public boolean IsSuper() {
        return 0 != (accessFlags.intValue() & Access_flags.ACC_SUPER);
    }

    public boolean IsInterface() {
        return 0 != (accessFlags.intValue() & Access_flags.ACC_INTERFACE);
    }

    public boolean IsAbstract() {
        return 0 != (accessFlags.intValue() & Access_flags.ACC_ABSTRACT);
    }

    public boolean IsSynthetic() {
        return 0 != (accessFlags.intValue() & Access_flags.ACC_SYNTHETIC);
    }

    public boolean IsAnnotation() {
        return 0 != (accessFlags.intValue() & Access_flags.ACC_ANNOTATION);
    }

    public boolean IsEnum() {
        return 0 != (accessFlags.intValue() & Access_flags.ACC_ENUM);
    }


    /* func (self *Class) isAccessibleTo(other *Class) bool {
         return self.IsPublic() ||
                 self.getPackageName() == other.getPackageName()
     }

     func (self *Class) getPackageName() string {
         if i := strings.LastIndex(self.name, "/"); i >= 0 {
             return self.name[:i]
         }
         return ""
     }*/
    public boolean isAccessibleTo(Class other) {
        return this.IsPublic() || this.getPackageName().equals(other.getPackageName());
    }

    public String getPackageName() {
        int i = name.lastIndexOf("/");
        if (i >= 0) {
            return name.substring(0, i + 1);
        }
        return "";
    }



   /* func (self *Class) isAssignableFrom(other *Class) bool {
        s, t := other, self

        if s == t {
            return true
        }

        if !t.IsInterface() {
            return s.isSubClassOf(t)
        } else {
            return s.isImplements(t)
        }
    }*/

    public boolean isAssignableFrom(Class other) {
        if (other == this) {
            return true;
        }
        if (!this.IsInterface()) {
            return other.isSubClassOf(this);
        } else {
            return other.isImplements(this);
        }
    }

    public boolean isImplements(Class iface) {
        for (Class c = this; c != null; c = c.superClass) {
            for (Class i : c.interfaces) {
                if (i == iface || i.isSubInterfaceOf(iface)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isSubClassOf(Class other) {
        for (Class c = this.superClass; c != null; c = c.superClass) {
            if (c == other) {
                return true;
            }
        }
        return false;
    }
/*    // self extends c
    func (self *Class) isSubClassOf(other *Class) bool {
        for c := self.superClass; c != nil; c = c.superClass {
            if c == other {
                return true
            }
        }
        return false
    }

    // self implements iface
    func (self *Class) isImplements(iface *Class) bool {
        for c := self; c != nil; c = c.superClass {
            for _, i := range c.interfaces {
                if i == iface || i.isSubInterfaceOf(iface) {
                    return true
                }
            }
        }
        return false
    }*/

    public boolean isSubInterfaceOf(Class iface) {
        for (Class superInterface : this.interfaces) {
            if (superInterface == iface || superInterface.isSubInterfaceOf(iface)) {
                return true;
            }
        }
        return false;
    }
    // self extends iface
/*    func (self *Class) isSubInterfaceOf(iface *Class) bool {
        for _, superInterface := range self.interfaces {
            if superInterface == iface || superInterface.isSubInterfaceOf(iface) {
                return true
            }
        }
        return false
    }*/
    /*func (self *Class) NewObject() *Object {
        return newObject(self)
    }*/
    public Object newObject(){
        return Object.newObject(this);
    }
}
