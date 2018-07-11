package ch06.classfile;

import ch06.classfile.ClassReader;
import ch06.classfile.ConstantInfo;
import org.joou.UShort;

public class ConstantInvokeDynamicInfo extends ConstantInfo {
 /*   type ConstantInvokeDynamicInfo struct {
        bootstrapMethodAttrIndex uint16
        nameAndTypeIndex         uint16
    }

    func (self *ConstantInvokeDynamicInfo) readInfo(reader *ClassReader) {
        self.bootstrapMethodAttrIndex = reader.readUint16()
        self.nameAndTypeIndex = reader.readUint16()
    }*/
    UShort  bootstrapMethodAttrIndex;
    UShort nameAndTypeIndex;

    @Override
    public int getType() {
        return ConstantInfo.CONSTANT_InvokeDynamic;
    }

    @Override
    public void readInfo(ClassReader reader) {
        this.bootstrapMethodAttrIndex=reader.readUInt16();
        this.nameAndTypeIndex=reader.readUInt16();
    }
}
