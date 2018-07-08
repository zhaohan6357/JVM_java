package ch03.classfile;

public class ConstantFieldrefInfo extends ConstantInfo {
    ConstantMemberrefInfo constantMemberrefInfo;
    public ConstantFieldrefInfo(ConstantMemberrefInfo constantMemberrefInfo) {
        this.constantMemberrefInfo=constantMemberrefInfo;
    }
}
