package ch07;

public class JVMUtils {

    public static byte[] subArray(byte[] data,int index){
        int len=data.length-index;
        byte[] subA=new byte[len];
        System.arraycopy(data,index,subA,0,len);
        return subA;
    }

}