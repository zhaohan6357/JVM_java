package ch05.instructions.comparisons.fcmp;

import ch05.rtda.Frame;

public class _FCMP {
    /*func _fcmp(frame *rtda.Frame, gFlag bool) {
        stack := frame.OperandStack()
        v2 := stack.PopFloat()
        v1 := stack.PopFloat()
        if v1 > v2 {
            stack.PushInt(1)
        } else if v1 == v2 {
            stack.PushInt(0)
        } else if v1 < v2 {
            stack.PushInt(-1)
        } else if gFlag {
            stack.PushInt(1)
        } else {
            stack.PushInt(-1)
        }
    }*/
    public static void _fcmp(Frame frame,boolean gFlag){
        float v2=frame.operandStack.popFloat();
        float v1=frame.operandStack.popFloat();
        if (v1 > v2) {
            frame.operandStack.pushInt(1);
        } else if (v1 == v2) {
            frame.operandStack.pushInt(0);
        } else if (v1 < v2) {
            frame.operandStack.pushInt(-1);
        } else if (gFlag) {
            frame.operandStack.pushInt(1);
        } else {
            frame.operandStack.pushInt(-1);
        }
    }
}
