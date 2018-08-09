package ch09.native_.java.lang;

import ch09.native_.registry.NativeMethod;
import ch09.native_.registry.Registry;
import ch09.rtda.Frame;
import org.joou.UInteger;

public class Float {
    public static final String jlFloat = "java/lang/Float";
    public static void init(){
       Registry.register(jlFloat, "floatToRawIntBits", "(F)I", floatToRawIntBits);
       Registry.register(jlFloat, "intBitsToFloat", "(I)F", intBitsToFloat);
    }

    public static NativeMethod floatToRawIntBits=new NativeMethod() {
        @Override
        public void method(Frame frame) {
            float val=frame.localVars.getFloat(UInteger.valueOf(0));
            int bits= java.lang.Float.floatToRawIntBits(val);
            frame.operandStack.pushInt(bits);
        }
    };
    public static NativeMethod intBitsToFloat=new NativeMethod() {
        @Override
        public void method(Frame frame) {
            int bits=frame.localVars.getInt(UInteger.valueOf(0));
            float value= java.lang.Float.intBitsToFloat(bits);
            frame.operandStack.pushFloat(value);
        }
    };


}
