package ch07.rtda.heap;

import ch07.classfile.ConstantClassInfo;
import ch07.rtda.heap.SymRef;
import ch07.rtda.heap.constant_pool.ConstantPool;

public class ClassRef extends SymRef {
    /*func newClassRef(cp *ConstantPool, classInfo *classfile.ConstantClassInfo) *ClassRef {
        ref := &ClassRef{}
        ref.cp = cp
        ref.className = classInfo.Name()
        return ref
    }*/
    public static ClassRef newClassRef( ConstantPool cp,ConstantClassInfo classInfo){
        ClassRef ref =new ClassRef();
        ref.cp=cp;
        ref.className=classInfo.name();
        return ref;
    }
}
