package ch08.classfile;

import org.joou.UByte;
import org.joou.UInteger;
import org.joou.ULong;
import org.joou.UShort;

import java.nio.ByteBuffer;

import static ch08.JVMUtils.subArray;
import static org.joou.Unsigned.*;

public class ClassReader {
    byte[] data;
    public UByte readUInt8(){
        UByte val=ubyte(data[0]);
        data=subArray(data,1);
        return val;
    }


    public UShort readUInt16(){
        ByteBuffer bf=ByteBuffer.allocate(2);
        bf.put(data,0,2);
        UShort val=ushort(bf.getShort(0));
        data=subArray(data,2);
        return val;
    }

    public UInteger readUInt32(){
        ByteBuffer bf=ByteBuffer.allocate(4);
        bf.put(data,0,4);
        UInteger val=uint(bf.getInt(0));
        data=subArray(data,4);
        return val;
    }

    public ULong readUInt64(){
        ByteBuffer bf=ByteBuffer.allocate(8);
        bf.put(data,0,8);
        ULong val=ulong(bf.getLong(0));
        data=subArray(data,8);
        return val;
    }

    public UShort[] readUInt16s(){
        UShort uInt16=readUInt16();
        int n=uInt16.intValue();
        UShort[] vals=new UShort[n];
        for(int i=0;i<n;i++){
            vals[i]=readUInt16();
        }
        return vals;
    }

    public byte[] readBytes(int n){

        ByteBuffer bf=ByteBuffer.allocate(n);
        bf.put(data,0,n);
        byte[] bytes=bf.array();
        data=subArray(data,n);
        return bytes;
    }

    public ClassReader(byte[] data) {
        this.data = data;
    }
    /*  public static void main(String[] args) {
        *//*ClassReader classReader=new ClassReader();
        byte[] d={0,2,0,12,0,12,1,2,3,4,5};
        classReader.data=d;
        System.out.println(Arrays.toString(classReader.data));
        UShort[] vals=classReader.readUInt16s();
        System.out.println(Arrays.toString(vals));
        System.out.println(Arrays.toString(classReader.data));*//*
        ULong uLong=ulong(-1);

        System.out.println(uLong);
    }*/
}
