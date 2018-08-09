package ch08.rtda;

import ch08.rtda.Slot;
import ch08.rtda.heap.Object;
import org.joou.UInteger;

//todo
public class OperandStack {

/*    type OperandStack struct {
        size uint
        slots []Slot
    }*/
    public UInteger size;
    public Slot[] slots;
/*
    func newOperandStack(maxStack uint) *OperandStack {
        if maxStack > 0 {
            return new OperandStack{
                slots: make([]Slot, maxStack),
            }
        }
        return nil
    }*/

    public static ch08.rtda.OperandStack newOperandStack(UInteger maxStack){
        if(maxStack==null){
            maxStack=UInteger.valueOf(0);
        }
        if(maxStack.intValue()>0){
            ch08.rtda.OperandStack operandStack=new ch08.rtda.OperandStack();
            operandStack.slots=new Slot[maxStack.intValue()];
            operandStack.size=UInteger.valueOf(0);

            for(int i=0;i<maxStack.intValue();i++){
                operandStack.slots[i]=new Slot();
            }
            return operandStack;
        }
        return null;
    }

/*    func (self *OperandStack) PushInt(val int32) {
        self.slots[self.size].num = val
        self.size++
    }
    func (self *OperandStack) PopInt() int32 {
        self.size--
        return self.slots[self.size].num
    }*/
    public void pushInt(int val){
        this.slots[size.intValue()].num=val;
        size=size.add(1);
   /*     System_.out.println("+++++++++++");
        System_.out.println(size);
        System_.out.println("+++++++++++");*/

    }
    public int popInt(){
        size=size.subtract(1);
   /*     System_.out.println("----------");
        System_.out.println(size);
        System_.out.println("----------");*/
        return this.slots[size.intValue()].num;
    }

  /*  func (self *OperandStack) PushFloat(val float32) {
        bits := math.Float32bits(val)
        self.slots[self.size].num = int32(bits)
        self.size++
    }func (self *OperandStack) PopFloat() float32 {
        self.size--
        bits := uint32(self.slots[self.size].num)
        return math.Float32frombits(bits)
    }*/
    public void pushFloat(float val){
        int bits=Float.floatToIntBits(val);
        slots[size.intValue()].num=bits;
        size=size.add(1);
    }
    public float popFloat(){
        size=size.subtract(1);
        int bits=slots[size.intValue()].num;
        return Float.intBitsToFloat(bits);
    }

    /*func (self *OperandStack) PushLong(val int64) {
        self.slots[self.size].num = int32(val)
        self.slots[self.size+1].num = int32(val >> 32)
        self.size += 2
    }func (self *OperandStack) PopLong() int64 {
        self.size -= 2
        low := uint32(self.slots[self.size].num)
        high := uint32(self.slots[self.size+1].num)
        return int64(high)<<32 | int64(low)
    }*/
    public void pushLong(long val){
        slots[size.intValue()].num = (int) val;
        slots[size.intValue() + 1].num = (int) (val >> 32);
        size=size.add(2);
    }
    public long popLong(){
        size=size.subtract(2);
        long low = UInteger.valueOf(slots[size.intValue()].num).longValue();
        long high = UInteger.valueOf(slots[size.intValue() + 1].num).longValue();
        long val = (high << 32) | low;
        return val;
    }

    /*func (self *OperandStack) PushDouble(val float64) {
        bits := math.Float64bits(val)
        self.PushLong(int64(bits))
    }func (self *OperandStack) PopDouble() float64 {
        bits := uint64(self.PopLong())
        return math.Float64frombits(bits)
    }*/
    public void pushDouble(double val){
        long bits=Double.doubleToLongBits(val);
        this.pushLong(bits);
    }

    public double popDouble(){
        long bits=this.popLong();
        return Double.longBitsToDouble(bits);
    }

    /*func (self *OperandStack) PushRef(ref *Object) {
        self.slots[self.size].ref = ref
        self.size++
    }func (self *OperandStack) PopRef() *Object {
        self.size--
        ref := self.slots[self.size].ref
        self.slots[self.size].ref = nil
        return ref
    }*/
    public void pushRef(Object ref){
        slots[size.intValue()].ref=ref;
        size=size.add(1);
    }

    public Object popRef(){
        size=size.subtract(1);
        Object ref=slots[size.intValue()].ref;
        slots[size.intValue()].ref=null;//todo mark
        return ref;
    }

    /*func (self *OperandStack) PushSlot(slot Slot) {
        self.slots[self.size] = slot
        self.size++
    }func (self *OperandStack) PopSlot() Slot {
        self.size--
        return self.slots[self.size]
    }*/
    public void pushSlot(Slot slot){
        slots[size.intValue()]=slot;
        size=size.add(1);
    }

    public Slot popSlot(){
        size=size.subtract(1);
        return slots[size.intValue()];
    }

 /*   func (self *OperandStack) GetRefFromTop(n uint) *heap.Object {
        return self.slots[self.size-1-n].ref
    }*/
 public Object getRefFromTop(UInteger n){
     return this.slots[this.size.intValue()-1-n.intValue()].ref;
 }

}
