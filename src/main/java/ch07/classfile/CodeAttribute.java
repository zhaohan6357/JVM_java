package ch07.classfile;

import ch07.classfile.AttributeInfo;
import ch07.classfile.ClassFile;
import ch07.classfile.ClassReader;
import ch07.classfile.ConstantPool;
import ch07.classfile.ExceptionTableEntry;
import org.joou.UShort;


public class CodeAttribute extends AttributeInfo {

/*    package classfile
    type CodeAttribute struct {
        cp ConstantPool
        maxStack uint16
        maxLocals uint16
        code []byte
        exceptionTable []*ExceptionTableEntry
        attributes []AttributeInfo
    }
    type ExceptionTableEntry struct {
        startPc uint16
        endPc uint16
        handlerPc uint16
        catchType uint16
    }
    func (self *CodeAttribute) readInfo(reader *ClassReader) {...}*/
    ConstantPool cp;
   public UShort maxStack;
    public  UShort maxLocals;
    public byte[] code;
    ExceptionTableEntry[] exceptionTable;
    AttributeInfo[] attributes;
/*
    func (self *CodeAttribute) readInfo(reader *ClassReader) {
        self.maxStack = reader.readUint16()
        self.maxLocals = reader.readUint16()
        codeLength := reader.readUint32()
        self.code = reader.readBytes(codeLength)
        self.exceptionTable = readExceptionTable(reader)
        self.attributes = readAttributes(reader, self.cp)
    }*/

    @Override
    public void readInfo(ClassReader reader) {
        maxStack=reader.readUInt16();
        maxLocals=reader.readUInt16();
        int codeLength=reader.readUInt32().intValue();
        code=reader.readBytes(codeLength);
        exceptionTable= ExceptionTableEntry.readExceptionTable(reader);
        attributes= ClassFile.readAttributes(reader,cp);
    }

    public CodeAttribute(ConstantPool cp) {
        this.cp=cp;
    }
}
