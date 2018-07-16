package ch08.rtda.heap;

import ch08.classfile.ConstantMethodrefInfo;
import ch08.rtda.heap.Class;
import ch08.rtda.heap.MemberRef;
import ch08.rtda.heap.Method;
import ch08.rtda.heap.Method_Lookup;
import ch08.rtda.heap.constant_pool.ConstantPool;

public class MethodRef extends MemberRef {
    /*type MethodRef struct {
        MemberRef
        method *Method
    }

    func newMethodRef(cp *ConstantPool, refInfo *classfile.ConstantMethodrefInfo) *MethodRef {
        ref := &MethodRef{}
        ref.cp = cp
        ref.copyMemberRefInfo(&refInfo.ConstantMemberrefInfo)
        return ref
    }*/
    ch08.rtda.heap.Method method;

    public static MethodRef newMethodRef(ConstantPool cp, ConstantMethodrefInfo refInfo) {
        MethodRef ref = new MethodRef();
        ref.cp = cp;
        ref.copyMemberRefInfo(refInfo);
        return ref;
    }

    public ch08.rtda.heap.Method ResolvedMethod() {
        if (this.method == null) {
            resolveMethodRef();
        }
        return this.method;
    }

    public void resolveMethodRef() {
        ch08.rtda.heap.Class d = this.cp.clazz;
        ch08.rtda.heap.Class c = this.ResolvedClass();
        if (c.IsInterface()) {
            System.out.println("java.lang.IncompatibleClassChangeError");
        }
        ch08.rtda.heap.Method m = lookuoMethod(c, this.name, this.descriptor);
        if (m == null) {
            System.out.println("java.lang.NoSuchMethodErro");
        }
        if (!m.isAccessibleTo(d)) {
            System.out.println("java.lang.IllegalAccessError");
        }
        this.method = m;
    }

    public ch08.rtda.heap.Method lookuoMethod(Class clazz, String name, String descriptor) {
        Method method = null;
        method = Method_Lookup.LookupMethodInClass(clazz, name, descriptor);
        if (method == null) {
            method = Method_Lookup.lookupMethodInInterfaces(clazz.interfaces, name, descriptor);
        }
        return method;
    }


}
