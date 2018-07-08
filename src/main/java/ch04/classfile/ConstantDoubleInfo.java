package ch04.classfile;

import org.joou.ULong;

public class ConstantDoubleInfo extends ConstantInfo {
    double val;

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
