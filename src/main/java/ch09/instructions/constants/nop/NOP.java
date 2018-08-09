package ch09.instructions.constants.nop;


import ch09.rtda.Frame;
import ch09.instructions.base.instruction.NoOperandsInstruction;

public class NOP extends NoOperandsInstruction {

    /*package constants
    import "jvmgo/ch09/instructions/base"
    import "jvmgo/ch09/rtda"
        // Do nothing
        type NOP struct{ base.NoOperandsInstruction }
        func (self *NOP) Execute(frame *rtda.Frame) {
            // 什么也不用做
        }*/

    @Override
    public void Execute(Frame frame) {
        //DO nothing
    }
}
