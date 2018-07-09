package ch05.instructions.constants.nop;


import ch05.rtda.Frame;
import ch05.instructions.base.instruction.NoOperandsInstruction;

public class NOP extends NoOperandsInstruction {

    /*package constants
    import "jvmgo/ch05/instructions/base"
    import "jvmgo/ch05/rtda"
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
