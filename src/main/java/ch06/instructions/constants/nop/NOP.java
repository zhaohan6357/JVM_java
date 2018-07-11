package ch06.instructions.constants.nop;


import ch06.rtda.Frame;
import ch06.instructions.base.instruction.NoOperandsInstruction;

public class NOP extends NoOperandsInstruction {

    /*package constants
    import "jvmgo/ch06/instructions/base"
    import "jvmgo/ch06/rtda"
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
