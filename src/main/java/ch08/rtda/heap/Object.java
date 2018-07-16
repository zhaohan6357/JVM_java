package ch08.rtda.heap;

import ch08.rtda.heap.Class;
import ch08.rtda.heap.Slots;

public class Object {
    public Class clazz;
    public java.lang.Object data;


    public static Object newObject(Class clazz) {
        Object obj = new Object();
        obj.clazz = clazz;
        obj.data = Slots.newSlots(clazz.instanceSlotCount);
        return obj;
    }

    public Object(Class clazz, java.lang.Object data) {
        this.clazz = clazz;
        this.data = data;
    }

    public Object() {
    }

    public boolean isInstanceOf(Class clazzz){
        return clazzz.isAssignableFrom(this.clazz);
    }
    public Slots fields(){
        return (Slots)(this.data);
    }

    public  byte[] Bytes()  {
        return (byte[])(this.data);
    }
    public  short[] Shorts()  {
        return (short[])(this.data);
    }
    public  int[] Ints()  {
        return  (int[])(this.data);
    }
    public  long[] Longs()  {
        return  (long[])(this.data);
    }
    public  char[] Chars()  {
        return (char[])(this.data);
    }
    public  float[] Floats(){
        return  (float[])(this.data);
    }
    public  double[] Doubles()  {
        return  (double[])(this.data);
    }
    public  Object[] Refs()  {
        return (Object[])(this.data);
    }
    public int arrayLength(){
        if(this.data.getClass()==byte[].class){
            return ((byte[])(data)).length;
        }else if(this.data.getClass()==short[].class){
            return ((short[])(data)).length;
        }else if(this.data.getClass()==int[].class){
            return ((int[])(data)).length;
        }else if(this.data.getClass()==long[].class){
            return ((long[])(data)).length;
        }else if(this.data.getClass()==char[].class){
            return ((char[])(data)).length;
        }else if(this.data.getClass()==float[].class){
            return ((float[])(data)).length;
        }else if(this.data.getClass()==double[].class){
            return ((double[])(data)).length;
        }else if(this.data.getClass()==Object[].class){
            return ((Object[])(data)).length;
        }else{
            System.out.println("no array!");
        }
        return 0;

    }

}
