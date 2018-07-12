package ch06.rtda.heap;

import ch06.classfile.CodeAttribute;
import ch06.classfile.MemberInfo;
import org.joou.UInteger;

public class Method extends ClassMember {
    /* type Method struct {
         ClassMember
         maxStack  uint
         maxLocals uint
         code      []byte
     }*/
    UInteger maxStack;
    UInteger maxLocals;
    byte[] code;

/*
    func newMethods(class *Class, cfMethods []*classfile.MemberInfo) []*Method {
        methods := make([]*Method, len(cfMethods))
        for i, cfMethod := range cfMethods {
            methods[i] = &Method{}
            methods[i].class = class
            methods[i].copyMemberInfo(cfMethod)
            methods[i].copyAttributes(cfMethod)
        }
        return methods
    }
*/
/*
func newMethods(class *Class, cfMethods []*classfile.MemberInfo) []*Method {
        methods := make([]*Method, len(cfMethods))
        for i, cfMethod := range cfMethods {
            methods[i] = &Method{}
            methods[i].class = class
            methods[i].copyMemberInfo(cfMethod)
            methods[i].copyAttributes(cfMethod)
        }
        return methods
    }
*/

    public static Method[] newMethods(Class clazz, MemberInfo[] cfMethods) {
        Method[] methods = new Method[cfMethods.length];
        for (int i = 0; i < methods.length; i++) {
            methods[i] = new Method();
            methods[i].clazz = clazz;
            methods[i].copyMemberInfo(cfMethods[i]);
            methods[i].copyAttributes(cfMethods[i]);
        }
        return methods;
    }

    /*func (self *Method) copyAttributes(cfMethod *classfile.MemberInfo) {
        if codeAttr := cfMethod.CodeAttribute(); codeAttr != nil {
            self.maxStack = codeAttr.MaxStack()
            self.maxLocals = codeAttr.MaxLocals()
            self.code = codeAttr.Code()
        }
    }*/
    public void copyAttributes(MemberInfo cfMethod) {
        CodeAttribute codeAttr = cfMethod.CodeAttribute();
        if (codeAttr != null) {
            maxStack = UInteger.valueOf(codeAttr.maxStack.intValue());
            maxLocals = UInteger.valueOf(codeAttr.maxLocals.intValue());
            code = codeAttr.code;

        }
    }
}
