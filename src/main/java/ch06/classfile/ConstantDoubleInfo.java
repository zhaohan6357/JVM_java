package ch06.classfile;

import ch06.classfile.ClassReader;
import ch06.classfile.ConstantInfo;
import org.joou.ULong;

public class ConstantDoubleInfo extends ConstantInfo {
    public double val;

    @Override
    public int getType() {
        return ConstantInfo.CONSTANT_Double;
    }

    @Override
    public void readInfo(ClassReader reader) {
        ULong uLong=reader.readUInt64();
        long lv=uLong.longValue();
        this.val=Double.longBitsToDouble(lv);
    }
}
