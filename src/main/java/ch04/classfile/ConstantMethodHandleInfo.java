package ch04.classfile;

import org.joou.UByte;
import org.joou.UShort;

public class ConstantMethodHandleInfo extends ConstantInfo {
  /*  type ConstantMethodHandleInfo struct {
        referenceKind  uint8
        referenceIndex uint16
    }

    func (self *ConstantMethodHandleInfo) readInfo(reader *ClassReader) {
        self.referenceKind = reader.readUint8()
        self.referenceIndex = reader.readUint16()
    }*/
    UByte referencedKind;
    UShort referenceIndex;

    @Override
    public int getType() {
        return ConstantInfo.CONSTANT_MethodHandle;
    }

    @Override
    public void readInfo(ClassReader reader) {
        referencedKind=reader.readUInt8();
        referenceIndex= reader.readUInt16();
    }
}
