package ch05.instructions.base;

import org.joou.UByte;
import org.joou.UShort;

public class ByteCodeReader {
    /*code []byte
    pc int*/
    byte[] code;
    int pc;

    /*func (self *BytecodeReader) Reset(code []byte, pc int) {
        self.code = code
        self.pc = pc
    }*/
    public void reset(byte[] code, int pc) {
        this.code = code;
        this.pc = pc;
    }

    /*    func (self *BytecodeReader) ReadUint8() uint8 {
        i := self.code[self.pc]
        self.pc++
        return i
    }*/


    public UByte readUint8() {
        UByte i = UByte.valueOf(code[pc]);
        pc++;
        return i;
    }

    /*   func (self *BytecodeReader) ReadInt8() int8 {
           return int8(self.ReadUint8())
       }*/
    public byte readInt8() {
        byte i = readUint8().byteValue();
        return i;
    }

    /*    func (self *BytecodeReader) ReadUint16() uint16 {
            byte1 := uint16(self.ReadUint8())
            byte2 := uint16(self.ReadUint8())
            return (byte1 << 8) | byte2
        }*/
    public UShort readUInt16() {
        short byte1=readUint8().shortValue();
        short byte2=readUint8().shortValue();
        short i=(short)(byte1<<8|byte2);
        return UShort.valueOf(i);
    }

 /*   func (self *BytecodeReader) ReadInt16() int16 {
        return int16(self.ReadUint16())
    }*/

    public short readInt16() {
        short i=readUInt16().shortValue();
        return i;
    }

/*    func (self *BytecodeReader) ReadInt32() int32 {
        byte1 := int32(self.ReadUint8())
        byte2 := int32(self.ReadUint8())
        byte3 := int32(self.ReadUint8())
        byte4 := int32(self.ReadUint8())
        return (byte1 << 24) | (byte2 << 16) | (byte3 << 8) | byte4
    }*/

    public int readInt32(){
        int byte1=readUint8().shortValue();
        int byte2=readUint8().shortValue();
        int byte3=readUint8().shortValue();
        int byte4=readUint8().shortValue();
        int i=(byte1<<24)|(byte2<<16)|(byte3<<8)|byte4;
        return i;
    }



 /*   func (self *BytecodeReader) SkipPadding() {
        for self.pc%4 != 0 {
            self.ReadUint8()
        }
    }*/
    public void skipPadding(){
        while(pc%4 != 0){
            readUint8();
        }
    }

    public int[] readInt32s(int n){
        int[] ints=new int[n];
        for(int i=0;i<n;i++){
            ints[i]=readInt32();
        }
        return ints;
    }
    /*func (self *BytecodeReader) ReadInt32s(n int32) []int32 {
        ints := make([]int32, n)
        for i := range ints {
            ints[i] = self.ReadInt32()
        }
        return ints
    }*/

}
