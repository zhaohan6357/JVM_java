package ch09.rtda.heap;

import ch09.classfile.ConstantMemberrefInfo;
import ch09.rtda.heap.SymRef;

public class   MemberRef extends SymRef {
    /*type MemberRef struct {
        SymRef
        name       string
        descriptor string
    }

    func (self *MemberRef) copyMemberRefInfo(refInfo *classfile.ConstantMemberrefInfo) {
        self.className = refInfo.ClassName()
        self.name, self.descriptor = refInfo.NameAndDescriptor()
    }*/
    public String name;
    public String descriptor;
    public void copyMemberRefInfo(ConstantMemberrefInfo refInfo){
        className=refInfo.className();
        String[] nameAndDes=refInfo.nameAndDescriptor();
        name=nameAndDes[0];
        descriptor=nameAndDes[1];
    }

}
