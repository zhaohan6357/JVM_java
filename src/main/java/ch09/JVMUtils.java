package ch09;

public class JVMUtils {

    public static byte[] subArray(byte[] data,int index){
        int len=data.length-index;
        byte[] subA=new byte[len];
        System.arraycopy(data,index,subA,0,len);
        return subA;
    }

    public static int[] intArraySub(int[] data,int index){
        int len=data.length-index;
        int[] subA=new int[len];
        System.arraycopy(data,index,subA,0,len);
        return subA;
    }

}
