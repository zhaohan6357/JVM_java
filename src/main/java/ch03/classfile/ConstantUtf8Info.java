package ch03.classfile;

import jdk.management.resource.internal.inst.SocketOutputStreamRMHooks;

import java.io.*;

public class ConstantUtf8Info  extends  ConstantInfo{
    public String str;

    @Override
    public int getType() {
        return ConstantInfo.CONSTANT_Utf8;
    }

    @Override
    public void readInfo(ClassReader reader) {
        int length=reader.readUInt16().intValue();
        byte[] bytes=reader.readBytes(length);
       /* ByteArrayInputStream bin=new ByteArrayInputStream(bytes);
        DataInputStream dataInputStream=new DataInputStream(bin);*/
        try {
            this.str=new String(bytes,"utf-8");
        /*    this.str = dataInputStream.readUTF();
            dataInputStream.close();
            bin.close();*/
        }catch (Exception e){

            System.out.println("read utf8 info failed");
        }
    }

/*    public static void main(String[] args) throws  Exception {

        byte[] buff = {0x00,0x02,0x50,0x49};
        ByteArrayInputStream bin = new ByteArrayInputStream(buff);
        DataInputStream dis = new DataInputStream(bin);
        String newName = dis.readUTF();
       // int newAge = dis.readInt();
        System.out.println(newName);
    }*/
}
