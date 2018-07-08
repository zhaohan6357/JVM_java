package ch03.classfile;

public class ConstantMethodrefInfo extends ConstantInfo {
    ConstantMemberrefInfo constantMemberrefInfo;
    public ConstantMethodrefInfo(ConstantMemberrefInfo constantMemberrefInfo) {
        this.constantMemberrefInfo=constantMemberrefInfo;
    }
}
