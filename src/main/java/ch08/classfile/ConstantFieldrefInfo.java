package ch08.classfile;

import ch08.classfile.ConstantInfo;
import ch08.classfile.ConstantMemberrefInfo;
import ch08.classfile.ConstantPool;

public class ConstantFieldrefInfo extends ConstantMemberrefInfo {
    public ConstantFieldrefInfo(ConstantPool cp) {
        super.cp=cp;
    }
    @Override
    public int getType() {
        return ConstantInfo.CONSTANT_Fieldref;
    }
}
