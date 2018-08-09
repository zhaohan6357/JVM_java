package ch09.instructions.reserved;

import ch09.instructions.base.instruction.NoOperandsInstruction;
import ch09.native_.java.lang.*;
import ch09.native_.java.lang.Double;
import ch09.native_.java.lang.Float;
import ch09.native_.java.lang.System_;
import ch09.native_.registry.NativeMethod;
import ch09.native_.registry.Registry;
import ch09.rtda.Frame;
import ch09.rtda.heap.Method;

public class INVOKE_NATIVE extends NoOperandsInstruction{
    {
        ObjectMethod.init();
        ClassMethod.init();
        Double.init();
        Float.init();
        System_.init();
        String_.init();
    }
    @Override
    public void Execute(Frame frame) {

        Method method=frame.method;
        String className=method.clazz.name;
        String methodName=method.name;
        String methodDescriptor=method.descriptor;
        NativeMethod nativeMethod= Registry.findNativeMethod(className,methodName,methodDescriptor);
        if(nativeMethod==null){
            String methodInfo = className + "." + methodName + methodDescriptor;
            System.out.println("java.lang.UnsatisfiedLinkError: " + methodInfo);
        }
        nativeMethod.method(frame);
    }
}
