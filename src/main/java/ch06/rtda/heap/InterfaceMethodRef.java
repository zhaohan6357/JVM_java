package ch06.rtda.heap;

import ch06.classfile.ConstantInterfaceMethodrefInfo;
import ch06.rtda.heap.constant_pool.ConstantPool;

public class InterfaceMethodRef extends MemberRef{
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

    public static InterfaceMethodRef newInterfaceMethodRef(ConstantPool cp, ConstantInterfaceMethodrefInfo refInfo){
        InterfaceMethodRef ref=new InterfaceMethodRef();
        ref.cp=cp;
        ref.copyMemberRefInfo(refInfo);
        return ref;
    }

    /*func (self *InterfaceMethodRef) ResolvedInterfaceMethod() *Method {
        if self.method == nil {
            self.resolveInterfaceMethodRef()
        }
        return self.method
    }

    // jvms8 5.4.3.4
    func (self *InterfaceMethodRef) resolveInterfaceMethodRef() {
        //class := self.ResolveClass()
        // todo
    }*/


}
