package ch03.classfile;

import org.joou.UShort;

public class ExceptionTableEntry {
 /*   type ExceptionTableEntry struct {
        startPc uint16
        endPc uint16
        handlerPc uint16
        catchType uint16
    }*/
    UShort starPc;
    UShort endPc;
    UShort handlerPc;
    UShort catchType;

/*    func readExceptionTable(reader *ClassReader) []*ExceptionTableEntry {
        exceptionTableLength := reader.readUint16()
        exceptionTable := make([]*ExceptionTableEntry, exceptionTableLength)
        for i := range exceptionTable {
            exceptionTable[i] = &ExceptionTableEntry{
                startPc: reader.readUint16(),
                        endPc: reader.readUint16(),
                        handlerPc: reader.readUint16(),
                        catchType: reader.readUint16(),
            }
        }
        return exceptionTable
    }*/

    public  static  ExceptionTableEntry[] readExceptionTable(ClassReader reader){
        int exceptionTableLength = reader.readUInt16().intValue();
        ExceptionTableEntry[] exceptionTable = new ExceptionTableEntry[exceptionTableLength];
        for(int i=0;i<exceptionTableLength;i++){
            exceptionTable[i]=new ExceptionTableEntry(reader.readUInt16(),reader.readUInt16(),
                    reader.readUInt16(),reader.readUInt16() );
        }
        return exceptionTable;
    }

    public ExceptionTableEntry(UShort starPc, UShort endPc, UShort handlerPc, UShort catchType) {
        this.starPc = starPc;
        this.endPc = endPc;
        this.handlerPc = handlerPc;
        this.catchType = catchType;
    }
}
