package ch09.rtda.heap;

import ch09.classfile.CodeAttribute;
import ch09.classfile.MemberInfo;
import ch09.rtda.heap.*;
import ch09.rtda.heap.Class;
import org.joou.UInteger;

import java.util.ArrayList;

public class Method extends ClassMember {

    public UInteger maxStack;
    public UInteger maxLocals;
    public byte[] code;
    public UInteger argSlotCount=UInteger.valueOf(0);

    public static Method[] newMethods(Class clazz, MemberInfo[] cfMethods) {
        Method[] methods = new Method[cfMethods.length];
        for (int i = 0; i < cfMethods.length; i++) {
            methods[i]=newMethod(clazz,cfMethods[i]);
        }
        return methods;
    }

    private static Method newMethod(Class clazz, MemberInfo cfMethod) {
        Method method=new Method();
        method.clazz=clazz;
        method.copyMemberInfo(cfMethod);
        method.copyAttributes(cfMethod);
        MethodDescriptor md=MethodDescriptorParser.parseMethodDescriptor(method.descriptor);
        method.calcArgSlotCount(md.parameterTypes);
        if(method.IsNative()){
            method.injectCodeAttribute(md.returnType);
        }
        return method;
    }

    public void  injectCodeAttribute(String returnType) {
        this.maxStack = UInteger.valueOf(4);
        this.maxLocals = this.argSlotCount;
        switch (returnType.charAt(0)) {
            case 'V':
                this.code = new byte[]{(byte)0xfe,(byte)0xb1}; // return
                return;
            case 'L':case '[':
                this.code = new byte[]{(byte)0xfe, (byte)0xb0}; // areturn
                return;
            case 'D':
                this.code = new byte[]{(byte)0xfe, (byte)0xaf}; // dreturn
                return;
            case 'F':
                this.code = new byte[]{(byte)0xfe, (byte)0xae}; // freturn
                return;
            case 'J':
                this.code = new byte[]{(byte)0xfe,(byte)0xad}; // lreturn
                return;
            default:
                this.code = new byte[]{(byte)0xfe, (byte)0xac}; // ireturn
                return;
        }
    }



    public void copyAttributes(MemberInfo cfMethod) {
        CodeAttribute codeAttr = cfMethod.CodeAttribute();
        if (codeAttr != null) {
            maxStack = UInteger.valueOf(codeAttr.maxStack.intValue());
            maxLocals = UInteger.valueOf(codeAttr.maxLocals.intValue());
            code = codeAttr.code;
        }
    }

    public void calcArgSlotCount(ArrayList<String> paramTypes){
       for(String paramType:paramTypes){
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
