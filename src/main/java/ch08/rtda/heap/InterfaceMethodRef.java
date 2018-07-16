package ch08.rtda.heap;

import ch08.classfile.ConstantInterfaceMethodrefInfo;
import ch08.rtda.heap.Class;
import ch08.rtda.heap.MemberRef;
import ch08.rtda.heap.Method;
import ch08.rtda.heap.Method_Lookup;
import ch08.rtda.heap.constant_pool.ConstantPool;

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
    ch08.rtda.heap.Method method;

    public static InterfaceMethodRef newInterfaceMethodRef(ConstantPool cp, ConstantInterfaceMethodrefInfo refInfo) {
        InterfaceMethodRef ref = new InterfaceMethodRef();
        ref.cp = cp;
        ref.copyMemberRefInfo(refInfo);
        return ref;
    }

    public ch08.rtda.heap.Method ResolvedInterfaceMethod() {
        if (this.method == null) {
            resolveInterfaceMethodRef();
        }
        return this.method;
    }

    public void resolveInterfaceMethodRef() {
        ch08.rtda.heap.Class d = this.cp.clazz;
        ch08.rtda.heap.Class c = this.ResolvedClass();
        if (!c.IsInterface()) {
            System.out.println("java.lang.IncompatibleClassChangeError");
        }
        ch08.rtda.heap.Method m = lookupInterfaceMethod(c, this.name, this.descriptor);
        if (m == null) {
            System.out.println("java.lang.NoSuchMethodErro");
        }
        if (!m.isAccessibleTo(d)) {
            System.out.println("java.lang.IllegalAccessError");
        }
        this.method = m;
    }

    public ch08.rtda.heap.Method lookupInterfaceMethod(Class iface, String name, String descriptor) {
        for (Method method : iface.methods) {
            if (method.name.equals(name) && method.descriptor.equals(descriptor)) {
                return method;
            }
        }
        return Method_Lookup.lookupMethodInInterfaces(iface.interfaces, name, descriptor);
    }
}
