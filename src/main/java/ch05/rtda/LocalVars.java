package ch05.rtda;

import org.joou.UInteger;


public class LocalVars {
    Slot[] localVars;

    /*   func newLocalVars(maxLocals uint) LocalVars {
           if maxLocals > 0 {
               return make([]Slot, maxLocals)
           }
           return nil
       }*/
    public static LocalVars newLocalVars(UInteger maxLocals) {
        if (maxLocals.intValue() > 0) {
            LocalVars local = new LocalVars();
            local.localVars = new Slot[maxLocals.intValue()];
            for(int i=0;i<maxLocals.intValue();i++){
                local.localVars[i]=new Slot(); //对象数组的每个对象都需要初始化
            }

            return local;
        }
        return null;
    }

    /*    func (self LocalVars) SetInt(index uint, val int32) {
            self[index].num = val
        }
        func (self LocalVars) GetInt(index uint) int32 {
            return self[index].num
        }*/
    public void setInt(UInteger index, int val) {
        localVars[index.intValue()].num = val;
    }

    public int getInt(UInteger index) {
        return localVars[index.intValue()].num;
    }

    /*   func (self LocalVars) SetFloat(index uint, val float32) {
           bits := math.Float32bits(val)
           self[index].num = int32(bits)
       }
       func (self LocalVars) GetFloat(index uint) float32 {
           bits := uint32(self[index].num)
           return math.Float32frombits(bits)
       }
   */
    public void setFloat(UInteger index, float val) {
        int f2IntBits = Float.floatToIntBits(val);
        localVars[index.intValue()].num = f2IntBits;
    }

    public float getFloat(UInteger index) {
        int f2IntBits = localVars[index.intValue()].num;
        return Float.intBitsToFloat(f2IntBits);
    }

    /*    func (self LocalVars) SetLong(index uint, val int64) {
            self[index].num = int32(val)
            self[index+1].num = int32(val >> 32)
        }
        func (self LocalVars) GetLong(index uint) int64 {
            low := uint32(self[index].num)
            high := uint32(self[index+1].num)
            return int64(high)<<32 | int64(low)
        }*/
    public void setLong(UInteger index, long val) {
        localVars[index.intValue()].num = (int) val;
        localVars[index.intValue() + 1].num = (int) (val >> 32);
    }

    public long getLong(UInteger index) {
        long low = UInteger.valueOf(localVars[index.intValue()].num).longValue();
        long high = UInteger.valueOf(localVars[index.intValue() + 1].num).longValue();
        long val = (high << 32) | low;
        return val;
    }

    /*    func (self LocalVars) SetDouble(index uint, val float64) {
            bits := math.Float64bits(val)
            self.SetLong(index, int64(bits))
        }
        func (self LocalVars) GetDouble(index uint) float64 {
            bits := uint64(self.GetLong(index))
            return math.Float64frombits(bits)
        }*/
    public void setDouble(UInteger index, double val) {
        long l2DoubleBits=Double.doubleToLongBits(val);
        setLong(index,l2DoubleBits);
    }

    public double getDouble(UInteger index) {
        long l2DoubleBits=getLong(index);
        double val=Double.longBitsToDouble(l2DoubleBits);
        return val;
    }

  /*  func (self LocalVars) SetRef(index uint, ref *Object) {
        self[index].ref = ref
    }
    func (self LocalVars) GetRef(index uint) *Object {
        return self[index].ref
    }*/
    public void setRef(UInteger index,Object ref ){
        localVars[index.intValue()].ref=ref;
    }

    public Object getRef(UInteger index){
        return localVars[index.intValue()].ref;
    }

//test for "long value decode "
/*    public static void main(String[] args) {
        long l = -1231123321123123l;
        int low = (int) l;
        int high = (int) (l >> 32);
        System.out.println(Long.toBinaryString(l));//       1001010 11001010 11011101 11110010 10110011
        System.out.println(Integer.toBinaryString(low));//          11001010 11011101 11110010 10110011
        System.out.println(Integer.toBinaryString(high));// 1001010
        System.out.println((((long) high) << 32) | (((long) low) & 0xffffffffl));
        ;

        System.out.println("------------------------");
        long H = UInteger.valueOf(high).longValue();
        long L = UInteger.valueOf(low).longValue();
        System.out.println(H << 32 | L);

        System.out.println("---------------------");
        long low2 = (long) (l & 0xffffffffl);
        ;
        System.out.println(low2);
        long high2 = (long) (l >> 32);
        System.out.println(high2 << 32 | low2);

    }*/
}
