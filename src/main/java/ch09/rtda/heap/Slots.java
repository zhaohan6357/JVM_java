package ch09.rtda.heap;

import ch09.rtda.Slot;
import ch09.rtda.heap.Object;
import org.joou.UInteger;

public class Slots {
    public Slot[] slots;


    public static Slots newSlots(UInteger maxLocals) {
        if (maxLocals.intValue() > 0) {
            Slots local = new Slots();
            local.slots = new Slot[maxLocals.intValue()];
            for(int i=0;i<maxLocals.intValue();i++){
                local.slots[i]=new Slot();
            }

            return local;
        }
        return null;
    }


    public void setInt(UInteger index, int val) {
        slots[index.intValue()].num = val;
    }

    public int getInt(UInteger index) {
        return slots[index.intValue()].num;
    }


    public void setFloat(UInteger index, float val) {
        int f2IntBits = Float.floatToIntBits(val);
        slots[index.intValue()].num = f2IntBits;
    }

    public float getFloat(UInteger index) {
        int f2IntBits = slots[index.intValue()].num;
        return Float.intBitsToFloat(f2IntBits);
    }


    public void setLong(UInteger index, long val) {
        slots[index.intValue()].num = (int) val;
        slots[index.intValue() + 1].num = (int) (val >> 32);
    }

    public long getLong(UInteger index) {
        long low = UInteger.valueOf(slots[index.intValue()].num).longValue();
        long high = UInteger.valueOf(slots[index.intValue() + 1].num).longValue();
        long val = (high << 32) | low;
        return val;
    }


    public void setDouble(UInteger index, double val) {
        long l2DoubleBits=Double.doubleToLongBits(val);
        setLong(index,l2DoubleBits);
    }

    public double getDouble(UInteger index) {
        long l2DoubleBits=getLong(index);
        double val=Double.longBitsToDouble(l2DoubleBits);
        return val;
    }


    public void setRef(UInteger index,Object ref ){
        slots[index.intValue()].ref=ref;
    }

    public Object getRef(UInteger index){
        return slots[index.intValue()].ref;
    }


}
