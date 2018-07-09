package ch05.classfile;

import org.joou.UShort;

public class ConstantMemberrefInfo extends ConstantInfo {

/*    type ConstantMemberrefInfo struct {
        cp ConstantPool
        classIndex uint16
        nameAndTypeIndex uint16
    }
    func (self *ConstantMemberrefInfo) readInfo(reader *ClassReader) {
        self.classIndex = reader.readUint16()
        self.nameAndTypeIndex = reader.readUint16()
    }
    func (self *ConstantMemberrefInfo) ClassName() string {
        return self.cp.getClassName(self.classIndex)
    }
    func (self *ConstantMemberrefInfo) NameAndDescriptor() (string, string) {
        return self.cp.getNameAndType(self.nameAndTypeIndex)
    }*/
    ConstantPool cp;
    UShort classIndex;
    UShort nameAndTypeIndex;

    @Override
    public void readInfo(ClassReader reader) {
        classIndex=reader.readUInt16();
        nameAndTypeIndex=reader.readUInt16();
    }
    @Override
    public String className(){
        return this.cp.getClassName(classIndex);
    }
    @Override
    public String[] nameAndDescriptor(){
        return  this.cp.getNameAndType(nameAndTypeIndex);
    }
}
