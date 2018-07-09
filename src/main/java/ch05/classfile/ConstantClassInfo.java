package ch05.classfile;

import org.joou.UShort;

public class ConstantClassInfo extends ConstantInfo {
    public UShort nameIndex;
    ConstantPool cp;
    public ConstantClassInfo(ConstantPool cp) {
            cp=cp;
    }

    @Override
    public int getType() {
        return ConstantInfo.CONSTANT_Class;
    }

    @Override
    public void readInfo(ClassReader reader) {
        this.nameIndex=reader.readUInt16();
    }
    public String name(){
        return cp.getUtf8(nameIndex);
    }
}
