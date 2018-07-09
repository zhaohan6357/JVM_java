package ch05.classfile;

import org.joou.UShort;

public class MemberInfo {

     private ConstantPool cp;// ConstantPool
     private UShort accessFlag;  //    accessFlags uint16
     private UShort nameIndex;  //    nameIndex uint16
     private UShort descriptionIndex;  //    descriptorIndex uint16
     private AttributeInfo[] attributes;  //    attributes []AttributeInfo

    public UShort getAccessFlag() {
        return accessFlag;
    }

    public String name(){
        return cp.getUtf8(nameIndex);
    }
    public String descripter(){
        return cp.getUtf8(descriptionIndex);
    }

    public void setAccessFlag(UShort accessFlag) {
        this.accessFlag = accessFlag;
    }

    public void setNameIndex(UShort nameIndex) {
        this.nameIndex = nameIndex;

    }
    public void setDescriptionIndex(UShort descriptionIndex) {
        this.descriptionIndex = descriptionIndex;
    }

    public void setAttributes(AttributeInfo[] attributes) {
        this.attributes = attributes;
    }

    public void setCp(ConstantPool cp) {
        this.cp = cp;
    }
}
