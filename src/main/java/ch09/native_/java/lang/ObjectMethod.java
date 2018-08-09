package ch09.native_.java.lang;

import ch06.classfile.SourceFileAttribute;
import ch09.native_.registry.NativeMethod;
import ch09.native_.registry.Registry;
import ch09.rtda.Frame;
import ch09.rtda.heap.Class;
import ch09.rtda.heap.Object;

public class ObjectMethod  {
    public static final String jlObject="java/lang/Object";
    public static void init(){
        Registry.register(jlObject, "getClass", "()Ljava/lang/Class;", getClass);
        Registry.register(jlObject, "hashCode", "()I", hashCode);
        Registry.register(jlObject, "clone", "()Ljava/lang/Object;", clone);
    }
    public static NativeMethod getClass=new NativeMethod() {
        @Override
        public void method(Frame frame) {
           Object this_= frame.localVars.getThis();
           Object clazz=this_.clazz.jClass;
           frame.operandStack.pushRef(clazz);
        }
    };

    public static NativeMethod hashCode=new NativeMethod() {
        @Override
        public void method(Frame frame) {
            Object this_=frame.localVars.getThis();
            int hash=this.hashCode();
            frame.operandStack.pushInt(hash);
        }
    };
    public static NativeMethod clone=new NativeMethod() {
        @Override
        public void method(Frame frame) {
            Object this_=frame.localVars.getThis();
            Class cloneable=this_.clazz.loader.loadClass("java/lang/Cloneable");
            if(!this_.clazz.isImplements(cloneable)){
                System.out.println("java.lang.CloneNotSupportedException");
            }
            frame.operandStack.pushRef(this_.Clone());

        }
    };


}
