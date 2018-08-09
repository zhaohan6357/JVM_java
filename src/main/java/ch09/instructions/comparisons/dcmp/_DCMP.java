package ch09.instructions.comparisons.dcmp;

import ch09.rtda.Frame;

public class _DCMP {

    public static void _dcmp(Frame frame,boolean gFlag){
        double v2=frame.operandStack.popDouble();
        double v1=frame.operandStack.popDouble();
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
