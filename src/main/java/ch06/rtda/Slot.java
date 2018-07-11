package ch06.rtda;

import ch06.rtda.Object;

public class Slot {
/*    type Slot struct {
        num int32
        ref *Object
    }*/
    public int num;
    public Object ref;

    @Override
    public String toString() {
        return "Slot{" +
                "num=" + num +
                ", ref=" + ref +
                '}';
    }
}
