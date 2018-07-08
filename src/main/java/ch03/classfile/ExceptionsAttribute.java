package ch03.classfile;

import org.joou.UShort;

public class ExceptionsAttribute extends AttributeInfo {

/*    type ExceptionsAttribute struct {
        exceptionIndexTable []uint16
    }
    func (self *ExceptionsAttribute) readInfo(reader *ClassReader) {
        self.exceptionIndexTable = reader.readUint16s()
    }
    func (self *ExceptionsAttribute) ExceptionIndexTable() []uint16 {
        return self.exceptionIndexTable
    }*/
    UShort[] exceptionIndexTable;

    @Override
    public void readInfo(ClassReader reader) {
        exceptionIndexTable=reader.readUInt16s();
    }

    public UShort[] getExceptionIndexTable() {
        return exceptionIndexTable;
    }
}
