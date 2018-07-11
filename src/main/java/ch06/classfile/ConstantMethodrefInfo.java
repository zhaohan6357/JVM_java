package ch06.classfile;

import ch06.classfile.ConstantInfo;
import ch06.classfile.ConstantMemberrefInfo;
import ch06.classfile.ConstantPool;

public class ConstantMethodrefInfo extends ConstantMemberrefInfo {
    public ConstantMethodrefInfo(ConstantPool cp) {
        super.cp=cp;
    }
    @Override
    public int getType() {
        return ConstantInfo.CONSTANT_Methodref;
    }
}
