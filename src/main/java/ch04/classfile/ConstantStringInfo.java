package ch04.classfile;

import org.joou.UShort;

public class ConstantStringInfo extends ConstantInfo {
    ConstantPool cp;
    UShort stringIndex;
    public ConstantStringInfo(ConstantPool cp) {
        cp=cp;
    }

    @Override
    public int getType() {
        return ConstantInfo.CONSTANT_String;
    }

    @Override
    public void readInfo(ClassReader reader) {
        this.stringIndex=reader.readUInt16();
    }

    public String getString(){
        return this.cp.getUtf8(stringIndex);
    }
}
