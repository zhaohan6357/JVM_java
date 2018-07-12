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
    public static Class newClass(ClassFile cf){
        Class clazz=new Class();
        clazz.accessFlags=cf.getAccesFlags();
        clazz.name=cf.className();
        clazz.superClassName=cf.superClassName();
        clazz.interfaceNames=cf.interfaceNames();
        clazz.constantPool=ConstantPool.newConstantPool(clazz,cf.getConstantPool());
        clazz.fields=Field.newFields(clazz,cf.getFields());
        clazz.methods=Method.newMethods(clazz,cf.getMethods());
        return clazz;
    }

    public boolean IsPublic() {
        return 0 != (accessFlags.intValue()&Access_flags.ACC_PUBLIC);
    }
    public boolean IsFinal() {
        return 0 != (accessFlags.intValue()&Access_flags.ACC_FINAL);
    }
    public boolean IsSuper() {
        return 0 != (accessFlags.intValue()&Access_flags.ACC_SUPER);
    }
    public boolean IsInterface() {
        return 0 != (accessFlags.intValue()&Access_flags.ACC_INTERFACE);
    }
    public boolean IsAbstract() {
        return 0 != (accessFlags.intValue()&Access_flags.ACC_ABSTRACT);
    }
    public boolean IsSynthetic() {
        return 0 != (accessFlags.intValue()&Access_flags.ACC_SYNTHETIC);
    }
    public boolean IsAnnotation() {
        return 0 != (accessFlags.intValue()&Access_flags.ACC_ANNOTATION);
    }
    public boolean IsEnum() {
        return 0 != (accessFlags.intValue()&Access_flags.ACC_ENUM);
    }



}
