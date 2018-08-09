package ch09.rtda.heap;

import ch09.classfile.ConstantMethodrefInfo;
import ch09.rtda.heap.Class;
import ch09.rtda.heap.MemberRef;
import ch09.rtda.heap.Method;
import ch09.rtda.heap.Method_Lookup;
import ch09.rtda.heap.constant_pool.ConstantPool;

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
    Method method;

    public static MethodRef newMethodRef(ConstantPool cp, ConstantMethodrefInfo refInfo) {
        MethodRef ref = new MethodRef();
        ref.cp = cp;
        ref.copyMemberRefInfo(refInfo);
        return ref;
    }

    public Method ResolvedMethod() {
        if (this.method == null) {
            resolveMethodRef();
        }
        return this.method;
    }

    public void resolveMethodRef() {
        Class d = this.cp.clazz;
        Class c = this.ResolvedClass();
        if (c.IsInterface()) {
            System.out.println("java.lang.IncompatibleClassChangeError");
        }
        Method m = lookuoMethod(c, this.name, this.descriptor);
        if (m == null) {
            System.out.println("java.lang.NoSuchMethodErro");
        }
        if (!m.isAccessibleTo(d)) {
            System.out.println("java.lang.IllegalAccessError-2");
        }
        this.method = m;
    }

    public Method lookuoMethod(Class clazz, String name, String descriptor) {
        Method method = null;
        method = Method_Lookup.LookupMethodInClass(clazz, name, descriptor);
        if (method == null) {
            method = Method_Lookup.lookupMethodInInterfaces(clazz.interfaces, name, descriptor);
        }
        return method;
    }


}
