package ch07.classfile;

import ch07.classfile.ConstantInfo;
import ch07.classfile.ConstantMemberrefInfo;
import ch07.classfile.ConstantPool;

public class ConstantInterfaceMethodrefInfo extends ConstantMemberrefInfo {
    public ConstantInterfaceMethodrefInfo(ConstantPool cp) {
        super.cp=cp;
    }
    @Override
    public int getType() {
        return ConstantInfo.CONSTANT_InterfaceMethodref;
    }
}
