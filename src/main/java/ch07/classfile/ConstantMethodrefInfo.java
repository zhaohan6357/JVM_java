package ch07.classfile;

import ch07.classfile.ConstantInfo;
import ch07.classfile.ConstantMemberrefInfo;
import ch07.classfile.ConstantPool;

public class ConstantMethodrefInfo extends ConstantMemberrefInfo {
    public ConstantMethodrefInfo(ConstantPool cp) {
        super.cp=cp;
    }
    @Override
    public int getType() {
        return ConstantInfo.CONSTANT_Methodref;
    }
}
