package ch06.rtda.heap;

import ch06.rtda.heap.constant_pool.ConstantPool;

public class SymRef {
    /*type SymRef struct {
        cp        *ConstantPool
        className string
        class     *Class
    }*/
    public ConstantPool cp;
    public String className;
    public Class clazz;
}
