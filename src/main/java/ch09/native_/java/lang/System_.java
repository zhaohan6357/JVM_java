package ch09.native_.java.lang;

import ch09.native_.registry.NativeMethod;
import ch09.native_.registry.Registry;
import ch09.rtda.Frame;
import ch09.rtda.LocalVars;
import ch09.rtda.heap.Object;
import org.joou.UInteger;

public class System_ {
    public static final String jlSystem = "java/lang/System";
    public static void init(){
        Registry.register(jlSystem, "arraycopy", "(Ljava/lang/Object;ILjava/lang/Object;II)V", arraycopy);
    }
    public static NativeMethod arraycopy=new NativeMethod() {
        @Override
        public void method(Frame frame) {
            LocalVars vars=frame.localVars;
            Object src=vars.getRef(UInteger.valueOf(0));
            int srcPos=vars.getInt(UInteger.valueOf(1));
            Object dest=vars.getRef(UInteger.valueOf(2));
            int destPos=vars.getInt(UInteger.valueOf(3));
            int length=vars.getInt(UInteger.valueOf(4));

            //if(src==null||)
            java.lang.System.arraycopy(src.data,srcPos,dest.data,destPos,length);
        }
    };
}
