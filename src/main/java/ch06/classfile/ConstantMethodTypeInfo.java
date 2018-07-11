package ch06.classfile;

import ch06.classfile.ClassReader;
import ch06.classfile.ConstantInfo;
import org.joou.UShort;

public class ConstantMethodTypeInfo extends ConstantInfo {
/*    type ConstantMethodTypeInfo struct {
        descriptorIndex uint16
    }

    func (self *ConstantMethodTypeInfo) readInfo(reader *ClassReader) {
        self.descriptorIndex = reader.readUint16()
    }*/
    UShort decriptorIndex;

    @Override
    public int getType() {
        return ConstantInfo.CONSTANT_MethodType;
    }

    @Override
    public void readInfo(ClassReader reader) {
        this.decriptorIndex=reader.readUInt16();
    }
}
