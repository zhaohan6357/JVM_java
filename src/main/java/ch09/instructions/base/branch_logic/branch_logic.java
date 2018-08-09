package ch09.instructions.base.branch_logic;

import ch09.rtda.Frame;

public class branch_logic {
    /*func Branch(frame *rtda.Frame, offset int) {
        pc := frame.Thread().PC()
        nextPC := pc + offset
        frame.SetNextPC(nextPC)
    }*/
    public static void Branch(Frame frame,int offset){
        int pc=frame.thread.pc;
        int nextpc=pc+offset;
        frame.setNextPC(nextpc);
    }
}
