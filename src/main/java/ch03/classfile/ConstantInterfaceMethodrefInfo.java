package ch03.classfile;

public class ConstantInterfaceMethodrefInfo extends ConstantInfo {
    ConstantMemberrefInfo constantMemberrefInfo;
    public ConstantInterfaceMethodrefInfo(ConstantMemberrefInfo constantMemberrefInfo) {
        this.constantMemberrefInfo=constantMemberrefInfo;
    }
}
