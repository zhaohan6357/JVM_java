package ch09.rtda;

import ch09.rtda.heap.Object;

public class Slot {
/*    type Slot struct {
        num int32
        ref *Object
    }*/
    public int num;
    public Object ref;

    public Slot(int num, Object ref) {
        this.num = num;
        this.ref = ref;
    }

    public Slot( ) {
    }

    @Override
    public String toString() {
        return "Slot{" +
                "num=" + num +
                ", ref=" + ref +
                '}';
    }
}
