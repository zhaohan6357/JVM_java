package ch07.rtda.heap;

import ch07.rtda.heap.Class;
import ch07.rtda.heap.Slots;

public class Object {
    public ch07.rtda.heap.Class clazz;
    public ch07.rtda.heap.Slots fields;

    //TODO
 /*func newObject(class *Class) *Object {
        return &Object{
            class: class,
            fields: newSlots(class.instanceSlotCount),
        }
    }*/
    public static Object newObject(ch07.rtda.heap.Class clazz) {
        Object obj = new Object();
        obj.clazz = clazz;
        obj.fields = Slots.newSlots(clazz.instanceSlotCount);
        return obj;
    }

    /*func (self *Object) IsInstanceOf(class *Class) bool {
        return class.isAssignableFrom(self.class)
    }*/
    public boolean isInstanceOf(Class clazzz){
        return clazzz.isAssignableFrom(this.clazz);
    }
}
