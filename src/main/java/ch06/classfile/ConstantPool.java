package ch06.classfile;

import ch06.classfile.ConstantClassInfo;
import ch06.classfile.ConstantInfo;
import ch06.classfile.ConstantNameAndTypeInfo;
import ch06.classfile.ConstantUtf8Info;
import org.joou.UShort;

public class ConstantPool {
    public ConstantInfo[] constantPool;


//    func readConstantPool(reader *ClassReader) ConstantPool {...}

//    func (self ConstantPool) getConstantInfo(index uint16) ConstantInfo {...}
    public ConstantInfo getConstantInfo(UShort index){
        ConstantInfo cpInfo=constantPool[index.intValue()];
        if(cpInfo!=null){
            return cpInfo;
        }else{
            System.out.println("Invalid constant pool Index");
            System.exit(1);
            //return null;
        }
        return null;
    }
//    func (self ConstantPool) getNameAndType(index uint16) (string, string) {...}
    public String[] getNameAndType(UShort index){
        ConstantNameAndTypeInfo ntInfo=(ConstantNameAndTypeInfo) getConstantInfo(index);
        String[] nameAndType=new String[2];
        nameAndType[0]=getUtf8(ntInfo.nameIndex);
        nameAndType[1]=getUtf8(ntInfo.descriptorIndex);
        return nameAndType;
    }
//    func (self ConstantPool) getClassName(index uint16) string {...}
    public String getClassName(UShort index){
        ConstantClassInfo classInfo=(ConstantClassInfo)getConstantInfo(index);
        return getUtf8(classInfo.nameIndex);
    }

//    func (self ConstantPool) getUtf8(index uint16) string {...}
    public String getUtf8(UShort Index){
        ConstantUtf8Info utf8Info=(ConstantUtf8Info)getConstantInfo(Index);
        return utf8Info.str;
    }









}
