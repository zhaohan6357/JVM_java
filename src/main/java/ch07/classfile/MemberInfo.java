package ch07.classfile;

import ch07.classfile.AttributeInfo;
import ch07.classfile.CodeAttribute;
import ch07.classfile.ConstantPool;
import ch07.classfile.ConstantValueAttribute;
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

    public String name() {
        return cp.getUtf8(nameIndex);
    }

    public String descripter() {
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

    /*  func (self *MemberInfo) CodeAttribute() *CodeAttribute {
          for _, attrInfo := range self.attributes {
              switch attrInfo.(type) {
  case *CodeAttribute:
              return attrInfo.(*CodeAttribute)
  }
          }r
          eturn nil
      }*/
    public CodeAttribute CodeAttribute() {
        for (AttributeInfo attributeInfo : attributes) {
            if (attributeInfo.getClass() == CodeAttribute.class) {
                return (CodeAttribute) attributeInfo;
            }
        }
        return null;
    }

    public ConstantValueAttribute ConstantValueAttribute(){
        for(AttributeInfo attributeInfo:attributes){
            if(attributeInfo.getClass()==ConstantValueAttribute.class){
                return (ConstantValueAttribute)attributeInfo;
            }
        }
        return null;
    }
    /*func (self *MemberInfo) ConstantValueAttribute() *ConstantValueAttribute {
        for _, attrInfo := range self.attributes {
            switch attrInfo.(type) {
		case *ConstantValueAttribute:
            return attrInfo.(*ConstantValueAttribute)
		}
        }
        return nil
    }*/

}
