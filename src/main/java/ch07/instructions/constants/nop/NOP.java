package ch07.instructions.constants.nop;


import ch07.rtda.Frame;
import ch07.instructions.base.instruction.NoOperandsInstruction;

public class NOP extends NoOperandsInstruction {

    /*package constants
    import "jvmgo/ch07/instructions/base"
    import "jvmgo/ch07/rtda"
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
