package ch09.classfile;

import ch09.classfile.AttributeInfo;
import ch09.classfile.ClassReader;
import ch09.classfile.ConstantPool;
import org.joou.UShort;


public class SourceFileAttribute extends AttributeInfo {
/*    type SourceFileAttribute struct {
        cp ConstantPool
        sourceFileIndex uint16
    }f
    unc (self *SourceFileAttribute) readInfo(reader *ClassReader) {
        self.sourceFileIndex = reader.readUint16()
    }f
    unc (self *SourceFileAttribute) FileName() string {
        return self.cp.getUtf8(self.sourceFileIndex)
    }*/
    ConstantPool cp;
    UShort sourceFileIndex;

    public SourceFileAttribute(ConstantPool cp) {
        this.cp=cp;
    }

    @Override
    public void readInfo(ClassReader reader) {
        this.sourceFileIndex=reader.readUInt16();
    }
    public String FileName(){
        return cp.getUtf8(sourceFileIndex);
    }
}
