package ch09.native_.java.lang;

import ch09.native_.registry.NativeMethod;
import ch09.native_.registry.Registry;
import ch09.rtda.Frame;
import org.joou.UInteger;

public class Double {
    public static final String jlDouble = "java/lang/Double";
    public static void init(){
        Registry.register(jlDouble, "doubleToRawLongBits", "(D)J", doubleToRawLongBits);
        Registry.register(jlDouble, "longBitsToDouble", "(J)D", longBitsToDouble);
    }

    public static NativeMethod doubleToRawLongBits=new NativeMethod() {
        @Override
        public void method(Frame frame) {
           double val=frame.localVars.getDouble(UInteger.valueOf(0));
            long bits= java.lang.Double.doubleToRawLongBits(val);
            frame.operandStack.pushLong(bits);
        }
    };
    public static NativeMethod longBitsToDouble=new NativeMethod() {
        @Override
        public void method(Frame frame) {
            long bits=frame.localVars.getLong(UInteger.valueOf(0));
            double value= java.lang.Double.longBitsToDouble(bits);
            frame.operandStack.pushDouble(value);
        }
    };
}
