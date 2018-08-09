package ch09.native_.registry;

import ch09.rtda.Frame;

import java.util.HashMap;

public class Registry {
    public static HashMap<String, NativeMethod> registry = new HashMap<>();
    public static NativeMethod emptyNativeMethod = new NativeMethod() {
        @Override
        public void method(Frame frame) {

        }
    };

    public static void register(String className,String methodName,
                                String methodDescriptor,NativeMethod method){

        String key=className + "~" + methodName + "~" + methodDescriptor;
        registry.put(key,method);
    }

    public static NativeMethod findNativeMethod(String className,String methodName,
                                                String methodDescriptor){
        String key=className + "~" + methodName + "~" + methodDescriptor;
        if(registry.containsKey(key)){
            return registry.get(key);
        }
        if( methodDescriptor.equals("()V") && methodName.equals("registerNatives")) {
            return emptyNativeMethod;
        }
        return null;
    }



}
