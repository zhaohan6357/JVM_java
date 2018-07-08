package ch03.classfile;

import org.joou.UInteger;
import org.joou.UShort;

public class ClassFile {
    private UInteger magic;
    private UShort minorVersion;
    private UShort majorVersion;
    private ConstantPool constantPool;
    private UShort accesFlags;
    private UShort thisClass;
    private UShort superClass;
    private UShort[] interfaces;
    private MemberInfo[] fields;
    private MemberInfo[] methods;
    private AttributeInfo[] attributes;

    public String className(){
        return constantPool.getClassName(thisClass);
    }

    public String superClassName(){
        if(superClass.intValue()>0){
            return constantPool.getClassName(superClass);
        }
        return "";
    }

    public String[] interfaceNames(){
        int len=interfaces.length;
        String[] interNames=new String[len];
        for(int i=0;i<len;i++){
            interNames[i]=constantPool.getClassName(interfaces[i]);
        }
        return interNames;
    }
    public void Parse(byte[] classData){
        try {
            ClassReader cr=new ClassReader(classData);
            read(cr);

        }catch (Exception e){
            System.out.println("parse failed");
        }
    }
    private void read(ClassReader reader){
         readAndCheckMagic(reader)  ;                 //        self.readAndCheckMagic(reader)
         readAndCaheckVersion(reader);                   //        self.readAndCheckVersion(reader)
         constantPool=readConstantPool(reader);//  self.constantPool = readConstantPool(reader)
         accesFlags=reader.readUInt16();    //  self.accessFlags = reader.readUint16()
         thisClass=reader.readUInt16() ;    //  self.thisClass = reader.readUint16()
         superClass=reader.readUInt16();    //  self.superClass = reader.readUint16()
         interfaces=reader.readUInt16s();   //  self.interfaces = reader.readUint16s()
         fields=readMembers(reader,constantPool);//  self.fields = readMembers(reader, self.constantPool)
         methods=readMembers(reader,constantPool);//  self.methods = readMembers(reader, self.constantPool)
         attributes=readAttributes(reader,constantPool);//  self.attributes = readAttributes(reader, self.constantPool)
    }
    //TODO
    private AttributeInfo[] readAttributes(ClassReader reader, ConstantPool constantPool) {
        return null;
    }

    private MemberInfo[] readMembers(ClassReader reader, ConstantPool constantPool) {
        int memberCount=reader.readUInt16().intValue();
        MemberInfo[] members=new MemberInfo[memberCount];
        for(int i=0;i<memberCount;i++){
            members[i]=readMember(reader,constantPool);
        }
        return members;
    }

    private MemberInfo readMember(ClassReader reader, ConstantPool constantPool) {
        MemberInfo member=new MemberInfo();
        member.setCp(constantPool);
        member.setAccessFlag(reader.readUInt16());
        member.setNameIndex(reader.readUInt16());
        member.setDescriptionIndex(reader.readUInt16());
        member.setAttributes(readAttributes(reader,constantPool));
        return member;
    }

    private ConstantPool readConstantPool(ClassReader reader) {
        ConstantPool pool=new ConstantPool();
        int cpCount=reader.readUInt16().intValue();
        pool.constantPool=new ConstantInfo[cpCount];
        for(int i=1;i<cpCount;i++){
            pool.constantPool[i]= readConstantInfo(reader, pool);
            if(pool.constantPool[i].getType()==ConstantInfo.CONSTANT_Float||
                    pool.constantPool[i].getType()==ConstantInfo.CONSTANT_Double){
                i++;
            }
        }
        return pool;
    }

    private ConstantInfo readConstantInfo(ClassReader reader, ConstantPool pool) {
       /* tag := reader.readUint8()
        c := newConstantInfo(tag, cp)
        c.readInfo(reader)
        return c*/
       int tag=reader.readUInt8().intValue();
       ConstantInfo c=ConstantInfo.returnConstantInfo(tag,pool);
       return c;
    }

    private void readAndCaheckVersion(ClassReader reader) {
        minorVersion=reader.readUInt16();
        majorVersion=reader.readUInt16();
        int minV=minorVersion.intValue();
        int majV=majorVersion.intValue();
        switch (majV){
            case 45:{
                System.out.println("the version is correct!");
                return;
            }
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52: {
                if(minV==0){
                    System.out.println("the version is correct!");
                    return;
                }
            }
        }
        System.out.println("the version is not correct");
        System.exit(1);
    }

    private void readAndCheckMagic(ClassReader reader) {
        magic=reader.readUInt32();
        if(magic.longValue()!=0xCAFEBABEl){
            System.out.println("magic number checked failed");
            System.exit(1);
        }
    }

    public UShort getMinorVersion() {
        return minorVersion;
    }

    public UShort getMajorVersion() {
        return majorVersion;
    }

    public ConstantPool getConstantPool() {
        return constantPool;
    }

    public UShort getAccesFlags() {
        return accesFlags;
    }

    public MemberInfo[] getFields() {
        return fields;
    }

    public MemberInfo[] getMethods() {
        return methods;
    }
}
