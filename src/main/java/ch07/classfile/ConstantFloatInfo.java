package ch07.classfile;

import ch07.classfile.ClassReader;
import ch07.classfile.ConstantInfo;
import org.joou.UInteger;

public class ConstantFloatInfo extends ConstantInfo {
/*    type ConstantFloatInfo struct {
        val float32
    }
    func (self *ConstantFloatInfo) readInfo(reader *ClassReader) {
        bytes := reader.readUint32()
        self.val = math.Float32frombits(bytes)
    }*/
    public float val;

    @Override
    public void readInfo(ClassReader reader) {
        UInteger uInt32=reader.readUInt32();
        int intval=uInt32.intValue();
        this.val=Float.intBitsToFloat(intval);
    }

    @Override
    public int getType() {
        return ConstantInfo.CONSTANT_Float;
    }
}
