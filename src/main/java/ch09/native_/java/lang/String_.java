package ch09.native_.java.lang;

import ch09.native_.registry.NativeMethod;
import ch09.native_.registry.Registry;
import ch09.rtda.Frame;
import ch09.rtda.heap.Object;
import ch09.rtda.heap.StringPool;

public class String_ {
    public static final String jlString= "java/lang/String";
    public static void init(){
        Registry.register(jlString, "intern", "()Ljava/lang/String;", intern);
    }
    public static NativeMethod intern=new NativeMethod() {
        @Override
        public void method(Frame frame) {
            Object this_=frame.localVars.getThis();
            Object interned=InternString(this_);
            frame.operandStack.pushRef(interned);
        }
    };


    public static Object InternString(Object jStr){
        String str= StringPool.getString(jStr);
        if(StringPool.internedString.containsKey(str)){
            return StringPool.internedString.get(str);
        }
        StringPool.internedString.put(str,jStr);
        return jStr;
    }
}
