package ch06.classfile;

import ch06.classfile.AttributeInfo;
import ch06.classfile.ClassReader;
import org.joou.UShort;

public class
ConstantValueAttribute extends AttributeInfo {
/*    package classfile
    type ConstantValueAttribute struct {
        constantValueIndex uint16
    }
    func (self *ConstantValueAttribute) readInfo(reader *ClassReader) {
        self.constantValueIndex = reader.readUint16()
    }
    func (self *ConstantValueAttribute) ConstantValueIndex() uint16 {
        return self.constantValueIndex
    }*/
    UShort constantValueIndex;

    @Override
    public void readInfo(ClassReader reader) {
        constantValueIndex=reader.readUInt16();
    }
    //todo would this method be used?
    public UShort getConstantValueIndex(){
        return constantValueIndex;
    }
}
