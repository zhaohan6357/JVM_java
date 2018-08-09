package ch09.instructions.loads.xaload;

import ch09.rtda.heap.Object;

public class CHECK {
    public static void checkNotNull(Object ref){
        if(ref==null){
            System.out.println("java.lang.NullPointerException");
            System.exit(1);
        }
    }

    public static void checkIndex(int arrLen,int index){
        if(index<0||index>=arrLen){
            System.out.println("ArrayIndexOutOfBoundsException");
            System.exit(1);
        }
    }
}
