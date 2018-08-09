package ch09.native_.java.lang;

import ch09.native_.registry.NativeMethod;
import ch09.native_.registry.Registry;
import ch09.rtda.Frame;
import ch09.rtda.heap.Class;
import ch09.rtda.heap.ClassLoader;
import ch09.rtda.heap.Object;
import ch09.rtda.heap.StringPool;
import org.joou.UInteger;

public class ClassMethod {
    public static final String jlClass = "java/lang/Class";
    public static NativeMethod getName0 = new NativeMethod() {
        @Override
        public void method(Frame frame) {
            Object this_ = frame.localVars.getThis();
            Class clazz = (Class) this_.extra;
            String name = clazz.javaName();
            Object nameObj = StringPool.JString(clazz.loader, name);
            frame.operandStack.pushRef(nameObj);
        }
    };

    public static NativeMethod desiredAssertionStatus0 = new NativeMethod() {
        @Override
        public void method(Frame frame) {
            frame.operandStack.pushBoolean(false);
        }
    };
    public static NativeMethod getPrimitiveClass = new NativeMethod() {
        @Override
        public void method(Frame frame) {
            Object nameObj = frame.localVars.getRef(UInteger.valueOf(0));
            String name = StringPool.getString(nameObj);
            ClassLoader loader = frame.method.clazz.loader;
            Object clazz = loader.loadClass(name).jClass;
            frame.operandStack.pushRef(clazz);
        }
    };


    public static void init() {
        Registry.register(jlClass, "getPrimitiveClass", "(Ljava/lang/String;)Ljava/lang/Class;", getPrimitiveClass);
        Registry.register(jlClass, "getName0", "()Ljava/lang/String;", getName0);
        Registry.register(jlClass, "desiredAssertionStatus0", "(Ljava/lang/Class;)Z", desiredAssertionStatus0);
        //Registry.register(jlClass, "isInterface", "()Z", isInterface);
        //Registry.register(jlClass, "isPrimitive", "()Z", isPrimitive);
    }

}
