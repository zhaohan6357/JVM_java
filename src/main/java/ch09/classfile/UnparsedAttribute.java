package ch09.classfile;

import ch09.classfile.AttributeInfo;
import ch09.classfile.ClassReader;
import org.joou.UInteger;

public class UnparsedAttribute extends AttributeInfo {
    /*type UnparsedAttribute struct {
        name string
        length uint32
        info []byte
    }
    func (self *UnparsedAttribute) readInfo(reader *ClassReader) {
        self.info = reader.readBytes(self.length)
    }*/
    String name;
    UInteger length;
    byte[] info;

    public UnparsedAttribute(String attrName, UInteger attrLen, byte[] info) {
        this.name=attrName;
        this.length=attrLen;
        this.info=info;
    }

    @Override
    public void readInfo(ClassReader reader) {
        info=reader.readBytes(length.intValue());
    }
}
