package ch08.rtda.heap;

import ch08.classfile.CodeAttribute;
import ch08.classfile.MemberInfo;
import ch08.rtda.heap.*;
import ch08.rtda.heap.Class;
import org.joou.UInteger;

public class Method extends ClassMember {
    /* type Method struct {
         ClassMember
         maxStack  uint
         maxLocals uint
         code      []byte
     }*/
    public UInteger maxStack;
    public UInteger maxLocals;
    public byte[] code;
    public UInteger argSlotCount=UInteger.valueOf(0);

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
            methods[i].calcArgSlotCount();
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

    public void calcArgSlotCount(){
       MethodDescriptor parsedDescriptor= MethodDescriptorParser.parseMethodDescriptor(this.descriptor);
       for(String paramType:parsedDescriptor.parameterTypes){
           argSlotCount=argSlotCount.add(1);
           if(paramType.equals("J")||paramType.equals("D")){
               argSlotCount=argSlotCount.add(1);
           }
       }
       if(!this.IsStatic()){
           argSlotCount=argSlotCount.add(1);
       }
    }

    public boolean IsSynchronized()  {
        return 0 != ((accessFlags.intValue())&(Access_flags.ACC_SYNCHRONIZED));
    }
    public boolean IsBridge()  {
        return 0 != ((accessFlags.intValue())&Access_flags.ACC_BRIDGE);
    }
    public boolean IsVarargs()  {
        return 0 != ((accessFlags.intValue())&Access_flags.ACC_VARARGS);
    }
    public boolean IsNative()  {
        return 0 != ((accessFlags.intValue())&Access_flags.ACC_NATIVE);
    }
    public boolean IsAbstract()  {
        return 0 != ((accessFlags.intValue())&Access_flags.ACC_ABSTRACT);
    }
    public boolean IsStrict() {
        return 0 != ((accessFlags.intValue())&Access_flags.ACC_STRICT);
    }
}
