package ch07.rtda.heap;

import ch07.rtda.heap.Class;
import ch07.rtda.heap.constant_pool.ConstantPool;

public class SymRef {
    /*type SymRef struct {
        cp        *ConstantPool
        className string
        class     *Class
    }*/
    public ConstantPool cp;
    public String className;
    public ch07.rtda.heap.Class clazz;


/*
    func (self *SymRef) ResolvedClass() *Class {
        if self.class == nil {
            self.resolveClassRef()
        }
        return self.class
    }
*/
    public ch07.rtda.heap.Class ResolvedClass(){
        if(clazz==null){
            resolveClassRef();
        }
        return clazz;
    }
    /*func (self *SymRef) resolveClassRef() {
        d := self.cp.class
        c := d.loader.LoadClass(self.className)
        if !c.isAccessibleTo(d) {
            panic("java.lang.IllegalAccessError")
        }

        self.class = c
    }*/
    public void resolveClassRef(){
        ch07.rtda.heap.Class d=cp.clazz;
        Class c=d.loader.loadClass(className);
        if(!c.isAccessibleTo(d)){
            System.out.println("java.lang.IllegalAccessError");
        }
        this.clazz=c;
    }
}