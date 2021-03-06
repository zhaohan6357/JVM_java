package ch09.classfile;

import ch09.classfile.ConstantInfo;
import ch09.classfile.ConstantMemberrefInfo;
import ch09.classfile.ConstantPool;

public class ConstantInterfaceMethodrefInfo extends ConstantMemberrefInfo {
    public ConstantInterfaceMethodrefInfo(ConstantPool cp) {
        super.cp=cp;
    }
    @Override
    public int getType() {
        return ConstantInfo.CONSTANT_InterfaceMethodref;
    }
}
