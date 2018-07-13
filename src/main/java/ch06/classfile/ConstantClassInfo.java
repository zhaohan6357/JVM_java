package ch06.classfile;

import ch06.classfile.ClassReader;
import ch06.classfile.ConstantInfo;
import ch06.classfile.ConstantPool;
import org.joou.UShort;

public class ConstantClassInfo extends ConstantInfo {
    public UShort nameIndex;
    ConstantPool cp;
    public ConstantClassInfo(ConstantPool cp) {
            this.cp=cp;//todo 不加this也错.?
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
