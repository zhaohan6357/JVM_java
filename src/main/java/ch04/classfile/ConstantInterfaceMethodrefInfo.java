package ch04.classfile;

public class ConstantInterfaceMethodrefInfo extends ConstantMemberrefInfo {
    public ConstantInterfaceMethodrefInfo(ConstantPool cp) {
        super.cp=cp;
    }
    @Override
    public int getType() {
        return ConstantInfo.CONSTANT_InterfaceMethodref;
    }
}
