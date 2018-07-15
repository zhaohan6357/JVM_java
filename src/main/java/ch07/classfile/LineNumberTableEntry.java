package ch07.classfile;

import org.joou.UShort;

public class LineNumberTableEntry {
/*    type LineNumberTableEntry struct {
        startPc uint16
        lineNumber uint16
    }*/
    UShort startPc;
    UShort lineNumber;

    public LineNumberTableEntry(UShort startPc, UShort lineNumber) {
        this.startPc = startPc;
        this.lineNumber = lineNumber;
    }
}
