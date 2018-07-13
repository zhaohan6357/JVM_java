package ch06.rtda.heap;

public class Object {
    public Class clazz;
    public Slots fields;

    //TODO
 /*func newObject(class *Class) *Object {
        return &Object{
            class: class,
            fields: newSlots(class.instanceSlotCount),
        }
    }*/
    public static Object newObject(Class clazz) {
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
