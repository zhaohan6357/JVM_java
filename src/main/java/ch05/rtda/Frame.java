package ch05.rtda;

import org.joou.UInteger;

import java.util.logging.XMLFormatter;

public class Frame {
/*    type Frame struct {
	lower        *Frame // stack is implemented as linked list
	localVars    LocalVars
	operandStack *OperandStack
	thread       *Thread
	nextPC       int // the next instruction after the call
}
    func newFrame(maxLocals, maxStack uint) *Frame {...}*/
    public Frame lower;
    public LocalVars localVars;
    public OperandStack operandStack;
    public Thread thread;
    public int nextPC;

/*    func NewFrame(maxLocals, maxStack uint) *Frame {
        return new Frame{
            localVars: newLocalVars(maxLocals),
                    operandStack: newOperandStack(maxStack),
        }
    }*/
    public static Frame newFrame(Thread thread,UInteger maxLocals, UInteger maxStack){
        Frame frame=new Frame();
        frame.thread=thread;
        frame.localVars= LocalVars.newLocalVars(maxLocals);
        frame.operandStack= OperandStack.newOperandStack(maxStack);
        return frame;
    }

    public LocalVars getLocalVars() {
        return localVars;
    }

    public OperandStack getOperandStack() {
        return operandStack;
    }
 /*   func (self *Frame) SetNextPC(nextPC int) {
        self.nextPC = nextPC
    }*/
    public void setNextPC(int nextPC){
        this.nextPC= nextPC;
    }
}
