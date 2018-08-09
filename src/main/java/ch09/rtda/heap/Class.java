package ch09.rtda.heap;

import ch09.classfile.ClassFile;
import ch09.rtda.heap.*;
import ch09.rtda.heap.ClassLoader;
import ch09.rtda.heap.Object;
import ch09.rtda.heap.constant_pool.ConstantPool;
import org.joou.UInteger;
import org.joou.UShort;


public class Class implements Cloneable {
    public UShort accessFlags;
    public String name;
    public String superClassName;
    public String[] interfaceNames=new String[0];
    public ConstantPool constantPool;
    public Field[] fields=new Field[0];
    public Method[] methods=new Method[0];
    public ClassLoader loader;
    public Class superClass;
    public Class[] interfaces=new Class[0];
    public UInteger instanceSlotCount;
    public UInteger staticSlotCount;
    public Slots staticVars;
    public boolean initStarted;
    public Object jClass;

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
    public boolean isJlObject(){
        return this.name.equals("java/lang/Object");
    }
    public boolean isJlCloneable(){
        return this.name.equals("java/lang/Cloneable");
    }
    public boolean isJioSerializable(){
        return this.name.equals("java/io/Serializable");
    }

    public boolean isAssignableFrom(Class other) {
        if (other == this) {
            return true;
        }
        if(!other.isArray()){
            if(!other.IsInterface()){
                if(!this.IsInterface()){
                    return other.isSubClassOf(this);
                }else{
                    return other.isImplements(this);
                }
            }else{
                if(!this.IsInterface()){
                    return this.isJlObject();
                }else{
                    return this.isJlCloneable();
                }
            }
        }else{
            Class sc=other.componentClass();
            Class tc=this.componentClass();
            return sc==tc||tc.isAssignableFrom(sc);
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


    public boolean isSubInterfaceOf(Class iface) {
        for (Class superInterface : this.interfaces) {
            if (superInterface == iface || superInterface.isSubInterfaceOf(iface)) {
                return true;
            }
        }
        return false;
    }

    public Object newObject(){
        return Object.newObject(this);
    }

    public Method getMainMethod(){
        return getStaticMethod("main","([Ljava/lang/String;)V");
    }
    public Method getStaticMethod(String name,String descriptor){
        for(Method method:this.methods){
            if(method.IsStatic()&&method.name.equals(name)&&method.descriptor.equals(descriptor)){
                return method;
            }
        }
        return null;
    }

    public void startInit(){
        this.initStarted=true;
    }

    public Method getClinitMethod(){
        return this.getStaticMethod("<clinit>","()V");
    }

    public boolean isArray(){
        return this.name.charAt(0)=='[';
    }

    public Class componentClass(){
        String componentClassName=CLASSNAME_HELPER.getComponentClassName(this.name);
        return this.loader.loadClass(componentClassName);
    }
    public Object newArray(UInteger count){
        if(!this.isArray()){
            System.out.println("Not array class:"+this.name);
            System.exit(1);
        }
        switch (this.name){
            case "[Z":
                return new Object(this,new byte[count.intValue()]);
            case "[B":
                return new Object(this,new byte[count.intValue()]);
            case "[C":
                return new Object(this,new char[count.intValue()]);
            case "[S":
                return new Object(this,new short[count.intValue()]);
            case "[I":
                return new Object(this,new int[count.intValue()]);
            case "[J":
                return new Object(this,new long[count.intValue()]);
            case "[F":
                return new Object(this,new float[count.intValue()]);
            case "[D":
                return new Object(this,new double[count.intValue()]);
            default:
                return new Object(this,new Object[count.intValue()]);
        }


    }

    public Class arrayClass(){
        String arrayClassName=CLASSNAME_HELPER.getArrayClassName(this.name);
        return this.loader.loadClass(arrayClassName);
    }

    public Field getField(String name,String descriptor,boolean
                          isStatic){
        for(Class c=this;c!=null;c=c.superClass){
            for(Field field:c.fields){
                if(field.IsStatic()==isStatic&&
                field.name.equals(name)&&field.descriptor
                    .equals(descriptor)){
                    return field;
                }
            }
        }
        return null;
    }


    public String javaName(){
        return this.name.replace('/','.');
    }

    @Override
    protected java.lang.Object clone(){
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
