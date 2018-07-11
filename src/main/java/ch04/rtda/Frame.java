package ch04.rtda;

import org.joou.UInteger;

public class Frame {
/*    type Frame struct {
        lower *Frame
        localVars LocalVars
        operandStack *OperandStack
    }
    func newFrame(maxLocals, maxStack uint) *Frame {...}*/
    public Frame lower;
    public LocalVars localVars;
    public OperandStack operandStack;

/*    func NewFrame(maxLocals, maxStack uint) *Frame {
        return new Frame{
            localVars: newLocalVars(maxLocals),
                    operandStack: newOperandStack(maxStack),
        }
    }*/
    public static Frame newFrame(UInteger maxLocals,UInteger maxStack){
        Frame frame=new Frame();
        frame.localVars=LocalVars.newLocalVars(maxLocals);
        frame.operandStack=OperandStack.newOperandStack(maxStack);
        return frame;
    }
}
