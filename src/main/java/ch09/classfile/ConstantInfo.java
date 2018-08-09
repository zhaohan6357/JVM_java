package ch09.classfile;

import ch09.classfile.*;
import ch09.classfile.ClassReader;
import ch09.classfile.ConstantPool;

public class ConstantInfo {

    public static final int CONSTANT_Class = 7;
    public static final int CONSTANT_Fieldref = 9;
    public static final int CONSTANT_Methodref = 10;
    public static final int CONSTANT_InterfaceMethodref = 11;
    public static final int CONSTANT_String = 8;
    public static final int CONSTANT_Integer = 3;
    public static final int CONSTANT_Float = 4;
    public static final int CONSTANT_Long = 5;
    public static final int CONSTANT_Double = 6;
    public static final int CONSTANT_NameAndType = 12;
    public static final int CONSTANT_Utf8 = 1;
    public static final int CONSTANT_MethodHandle = 15;
    public static final int CONSTANT_MethodType = 16;
    public static final int CONSTANT_InvokeDynamic = 18;
    public int getType(){
         return -1;
    }
    public void readInfo(ClassReader reader){
    }

    //todo 此处需留意 子类或许需要重写这个方法
    public String className(){
        return null;
    }
    public String[] nameAndDescriptor(){
        return null;
    }
    public static ch09.classfile.ConstantInfo newConstantInfo(int tag, ConstantPool cp){
            switch (tag){
                case CONSTANT_Integer:
                    return new ConstantIntegerInfo();
                case CONSTANT_Float:
                    return new ConstantFloatInfo();
                case CONSTANT_Long:
                    return new ConstantLongInfo();
                case CONSTANT_Double:
                    return new ConstantDoubleInfo();
                case CONSTANT_Utf8:
                    return new ConstantUtf8Info();
                case CONSTANT_String:
                    return new ConstantStringInfo(cp);
                case CONSTANT_Class:
                    return new ConstantClassInfo(cp);
                case CONSTANT_Fieldref:
                    return new ConstantFieldrefInfo(cp);
                case CONSTANT_Methodref:
                    return new ConstantMethodrefInfo(cp);
                case CONSTANT_InterfaceMethodref:
                    return new ConstantInterfaceMethodrefInfo(cp);
                case CONSTANT_NameAndType:
                    return new ConstantNameAndTypeInfo();
                case CONSTANT_MethodType:
                    return new ConstantMethodTypeInfo();
                case CONSTANT_MethodHandle:
                    return new ConstantMethodHandleInfo();
                case CONSTANT_InvokeDynamic:
                    return new ConstantInvokeDynamicInfo();
                default:{
                    System.out.println("java.lang.ClassFormatError: constant pool tag!");
                    return null;
                }
            }
    }



}
