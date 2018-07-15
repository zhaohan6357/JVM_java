package ch07.classfile;

import ch07.classfile.ConstantInfo;
import ch07.classfile.ConstantMemberrefInfo;
import ch07.classfile.ConstantPool;

public class ConstantFieldrefInfo extends ConstantMemberrefInfo {
    public ConstantFieldrefInfo(ConstantPool cp) {
        super.cp=cp;
    }
    @Override
    public int getType() {
        return ConstantInfo.CONSTANT_Fieldref;
    }
}
