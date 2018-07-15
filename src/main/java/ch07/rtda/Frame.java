package ch07.rtda;

import ch07.rtda.LocalVars;
import ch07.rtda.OperandStack;
import ch07.rtda.Thread;
import ch07.rtda.heap.Method;
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
    public ch07.rtda.Frame lower;
    public LocalVars localVars;
    public OperandStack operandStack;
    public Thread thread;
    public Method method;
    public int nextPC;

/*    func NewFrame(maxLocals, maxStack uint) *Frame {
        return new Frame{
            localVars: newLocalVars(maxLocals),
                    operandStack: newOperandStack(maxStack),
        }
    }*/
    public static ch07.rtda.Frame newFrame(Thread thread, Method method){
        ch07.rtda.Frame frame=new ch07.rtda.Frame();
        frame.thread=thread;
        frame.method=method;
        frame.localVars= LocalVars.newLocalVars(method.maxLocals);
        frame.operandStack= OperandStack.newOperandStack(method.maxStack);
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

    public void revertNextPC(){
        this.nextPC=this.thread.pc;
    }
}
