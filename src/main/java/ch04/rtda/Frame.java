package ch04.rtda;

public class Frame {
/*    type Frame struct {
        lower *Frame
        localVars LocalVars
        operandStack *OperandStack
    }
    func newFrame(maxLocals, maxStack uint) *Frame {...}*/


    public Frame lower;
    LocalVars localVars;
    OperandStack operandStack;
}
