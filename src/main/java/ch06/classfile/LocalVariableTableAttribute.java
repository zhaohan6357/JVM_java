package ch06.classfile;

import ch06.classfile.AttributeInfo;
import ch06.classfile.ClassReader;
import ch06.classfile.LocalVariableTableEntry;

public class LocalVariableTableAttribute extends AttributeInfo {
/*    type LocalVariableTableAttribute struct {
        localVariableTable []*LocalVariableTableEntry
    }

    type LocalVariableTableEntry struct {
        startPc         uint16
        length          uint16
        nameIndex       uint16
        descriptorIndex uint16
        index           uint16
    }*/
    LocalVariableTableEntry[] localVariableTable;
/*    func (self *LocalVariableTableAttribute) readInfo(reader *ClassReader) {
        localVariableTableLength := reader.readUint16()
        self.localVariableTable = make([]*LocalVariableTableEntry, localVariableTableLength)
        for i := range self.localVariableTable {
            self.localVariableTable[i] = new LocalVariableTableEntry{
                startPc:         reader.readUint16(),
                        length:          reader.readUint16(),
                        nameIndex:       reader.readUint16(),
                        descriptorIndex: reader.readUint16(),
                        index:           reader.readUint16(),
            }
        }
    }*/

    @Override
    public void readInfo(ClassReader reader) {
        int localVariableTableLength = reader.readUInt16().intValue();
        localVariableTable=new LocalVariableTableEntry[localVariableTableLength];
        for(int i=0;i<localVariableTableLength;i++){
            localVariableTable[i]=new LocalVariableTableEntry(reader.readUInt16(),reader.readUInt16(),
                    reader.readUInt16(),reader.readUInt16(),reader.readUInt16());
        }
    }
}
