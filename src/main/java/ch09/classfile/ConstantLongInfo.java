package ch09.classfile;

import ch09.classfile.ClassReader;
import ch09.classfile.ConstantInfo;
import org.joou.ULong;

public class ConstantLongInfo extends ConstantInfo {
 /*   type ConstantLongInfo struct {
        val int64
    }
    func (self *ConstantLongInfo) readInfo(reader *ClassReader) {
        bytes := reader.readUint64()
        self.val = int64(bytes)*/
    public long val;

    @Override
    public int getType() {
        return ConstantInfo.CONSTANT_Long;
    }
    @Override
    public void readInfo(ClassReader reader) {
        ULong uLong=reader.readUInt64();
        this.val=uLong.longValue();
    }
}
