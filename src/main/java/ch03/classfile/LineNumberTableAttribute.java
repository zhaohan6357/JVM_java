package ch03.classfile;

public class LineNumberTableAttribute extends AttributeInfo {
  /*  package classfile
    type LineNumberTableAttribute struct {
        lineNumberTable []*LineNumberTableEntry
    }
    type LineNumberTableEntry struct {
        startPc uint16
        lineNumber uint16
    }
    func (self *LineNumberTableAttribute) readInfo(reader *ClassReader) {...}*/
    LineNumberTableEntry[] lineNumberTable;

  /*  func (self *LineNumberTableAttribute) readInfo(reader *ClassReader) {
        lineNumberTableLength := reader.readUint16()
        self.lineNumberTable = make([]*LineNumberTableEntry, lineNumberTableLength)
        for i := range self.lineNumberTable {
            self.lineNumberTable[i] = &LineNumberTableEntry{
                startPc: reader.readUint16(),
                        lineNumber: reader.readUint16(),
            }
        }
    }*/

    @Override
    public void readInfo(ClassReader reader) {
        int lineNumberTabelLength=reader.readUInt16().intValue();
        lineNumberTable=new LineNumberTableEntry[lineNumberTabelLength];
        for(int i=0;i<lineNumberTabelLength;i++){
            lineNumberTable[i]=new LineNumberTableEntry(reader.readUInt16(),reader.readUInt16());
        }
    }
}
