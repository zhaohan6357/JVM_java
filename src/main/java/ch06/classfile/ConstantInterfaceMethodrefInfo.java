package ch06.classfile;

import ch06.classfile.ConstantInfo;
import ch06.classfile.ConstantMemberrefInfo;
import ch06.classfile.ConstantPool;

public class ConstantInterfaceMethodrefInfo extends ConstantMemberrefInfo {
    public ConstantInterfaceMethodrefInfo(ConstantPool cp) {
        super.cp=cp;
    }
    @Override
    public int getType() {
        return ConstantInfo.CONSTANT_InterfaceMethodref;
    }
}
