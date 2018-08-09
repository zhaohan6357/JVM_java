package ch09.classfile;

import org.joou.UShort;

public class LocalVariableTableEntry {
 /*   type LocalVariableTableEntry struct {
        startPc         uint16
        length          uint16
        nameIndex       uint16
        descriptorIndex uint16
        index           uint16
    }*/
    UShort startPc;
    UShort length;
    UShort nameIndex;
    UShort descriptorIndex;
    UShort index;

    public LocalVariableTableEntry(UShort startPc, UShort length, UShort nameIndex, UShort descriptorIndex, UShort index) {
        this.startPc = startPc;
        this.length = length;
        this.nameIndex = nameIndex;
        this.descriptorIndex = descriptorIndex;
        this.index = index;
    }
}
