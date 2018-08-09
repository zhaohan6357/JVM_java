package ch09.rtda.heap;

import ch09.rtda.heap.Class;
import ch09.rtda.heap.Field;
import ch09.rtda.heap.Slots;

import java.io.File;

public class Object implements Cloneable{
    public Class clazz;
    public java.lang.Object data;
    public java.lang.Object extra;

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

    public Object getRefVar(String name,String descriptor){
        ch09.rtda.heap.Field field=this.clazz.getField(name,descriptor,false);
        Slots slots=(Slots)this.data;
        return slots.getRef(field.slotId);
    }

    public void setRefVar(String name,String descriptor,Object ref){
        Field filed=this.clazz.getField(name,descriptor,false);
        Slots slots=(Slots)this.data;
        slots.setRef(filed.slotId,ref);
    }


    /*func (self *Object) Clone() *Object {
        return &Object{
            class: self.class,
                    data:  self.cloneData(),
        }
    }*/

    public Object Clone(){
        return (Object) this.clone();
    }
    @Override
    protected java.lang.Object clone()  {
        Object newObjec=null;
        try {
            newObjec=(Object)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        newObjec.clazz=(Class)(clazz.clone());
        return newObjec;
    }

}
