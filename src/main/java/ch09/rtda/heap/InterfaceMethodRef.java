package ch09.rtda.heap;

import ch09.classfile.ConstantInterfaceMethodrefInfo;
import ch09.rtda.heap.Class;
import ch09.rtda.heap.MemberRef;
import ch09.rtda.heap.Method;
import ch09.rtda.heap.Method_Lookup;
import ch09.rtda.heap.constant_pool.ConstantPool;

public class InterfaceMethodRef extends MemberRef {
    /*
        type InterfaceMethodRef struct {
            MemberRef
            method *Method
        }

        func newInterfaceMethodRef(cp *ConstantPool, refInfo *classfile.ConstantInterfaceMethodrefInfo) *InterfaceMethodRef {
            ref := &InterfaceMethodRef{}
            ref.cp = cp
            ref.copyMemberRefInfo(&refInfo.ConstantMemberrefInfo)
            return ref
        }
    */
    Method method;

    public static InterfaceMethodRef newInterfaceMethodRef(ConstantPool cp, ConstantInterfaceMethodrefInfo refInfo) {
        InterfaceMethodRef ref = new InterfaceMethodRef();
        ref.cp = cp;
        ref.copyMemberRefInfo(refInfo);
        return ref;
    }

    public Method ResolvedInterfaceMethod() {
        if (this.method == null) {
            resolveInterfaceMethodRef();
        }
        return this.method;
    }

    public void resolveInterfaceMethodRef() {
        Class d = this.cp.clazz;
        Class c = this.ResolvedClass();
        if (!c.IsInterface()) {
            System.out.println("java.lang.IncompatibleClassChangeError");
        }
        Method m = lookupInterfaceMethod(c, this.name, this.descriptor);
        if (m == null) {
            System.out.println("java.lang.NoSuchMethodErro");
        }
        if (!m.isAccessibleTo(d)) {
            System.out.println("java.lang.IllegalAccessError-3");
        }
        this.method = m;
    }

    public Method lookupInterfaceMethod(Class iface, String name, String descriptor) {
        for (Method method : iface.methods) {
            if (method.name.equals(name) && method.descriptor.equals(descriptor)) {
                return method;
            }
        }
        return Method_Lookup.lookupMethodInInterfaces(iface.interfaces, name, descriptor);
    }
}
