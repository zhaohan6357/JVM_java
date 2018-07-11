package ch06.classfile;

import ch06.classfile.ClassReader;
import ch06.classfile.ConstantInfo;
import org.joou.UShort;

public class ConstantNameAndTypeInfo extends ConstantInfo {
/*
    type ConstantNameAndTypeInfo struct {
        nameIndex uint16
        descriptorIndex uint16
    }
    func (self *ConstantNameAndTypeInfo) readInfo(reader *ClassReader) {
        self.nameIndex = reader.readUint16()
        self.descriptorIndex = reader.readUint16()
    }
*/

    public UShort nameIndex;
    public UShort descriptorIndex;

    @Override
    public int getType() {
        return ConstantInfo.CONSTANT_NameAndType;
    }

    @Override
    public void readInfo(ClassReader reader) {
        this.nameIndex=reader.readUInt16();
        this.descriptorIndex=reader.readUInt16();
    }
}
