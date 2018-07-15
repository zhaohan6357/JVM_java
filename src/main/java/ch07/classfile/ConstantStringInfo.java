package ch07.classfile;

import ch07.classfile.ClassReader;
import ch07.classfile.ConstantInfo;
import ch07.classfile.ConstantPool;
import org.joou.UShort;

public class ConstantStringInfo extends ConstantInfo {
    ConstantPool cp;
    UShort stringIndex;
    public ConstantStringInfo(ConstantPool cp) {
        this.cp=cp;
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
