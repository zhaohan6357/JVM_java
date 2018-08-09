package ch09.instructions.base.method_invoke_logic;

import ch09.rtda.Frame;
import ch09.rtda.Slot;
import ch09.rtda.Thread;
import ch09.rtda.heap.Method;
import org.joou.UInteger;

public class InvokeMethod {
    public static void InvokeMethod(Frame invokerFrame, Method method) {
        Thread thread = invokerFrame.thread;
        Frame newFrame = thread.newFrame(method);
        thread.pushFrame(newFrame);
        int argSlotCount = method.argSlotCount.intValue();
        if (argSlotCount > 0) {
            for (int i = argSlotCount - 1; i >= 0; i--) {
                Slot slot = invokerFrame.operandStack.popSlot();
                newFrame.localVars.setSlot(UInteger.valueOf(i), slot);
            }
        }
    }
}
