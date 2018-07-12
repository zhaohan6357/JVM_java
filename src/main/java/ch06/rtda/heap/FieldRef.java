package ch06.rtda.heap;

import ch06.classfile.ConstantFieldrefInfo;
import ch06.rtda.heap.constant_pool.ConstantPool;

public class FieldRef extends MemberRef {
    /* type FieldRef struct {
         MemberRef
         field *Field
     }

     func newFieldRef(cp *ConstantPool, refInfo *classfile.ConstantFieldrefInfo) *FieldRef {
         ref := &FieldRef{}
         ref.cp = cp
         ref.copyMemberRefInfo(&refInfo.ConstantMemberrefInfo)
         return ref
     }*/
    Field field;

    public static FieldRef newFieldRef(ConstantPool cp, ConstantFieldrefInfo refInfo) {
        FieldRef ref = new FieldRef();
        ref.cp = cp;
        // ConstantMemberrefInfo constantMemberrefInfo=(ConstantMemberrefInfo)refInfo;
        ref.copyMemberRefInfo(refInfo);
        return ref;
    }
}
