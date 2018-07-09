package ch05.classfile;

public class ConstantFieldrefInfo extends ConstantMemberrefInfo {
    public ConstantFieldrefInfo(ConstantPool cp) {
        super.cp=cp;
    }
    @Override
    public int getType() {
        return ConstantInfo.CONSTANT_Fieldref;
    }
}
