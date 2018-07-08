package ch04.classfile;

import org.joou.UInteger;

public class ConstantIntegerInfo extends ConstantInfo {
    int val;
 /*   func (self *ConstantIntegerInfo) readInfo(reader *ClassReader) {
        bytes := reader.readUint32()
        self.val = int32(bytes)
    }*/

    @Override
    public void readInfo(ClassReader reader) {
        UInteger intval=reader.readUInt32();
        this.val=intval.intValue();
    }

    @Override
    public int getType() {
        return ConstantInfo.CONSTANT_Integer;
    }
}
