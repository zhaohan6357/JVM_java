package ch08.rtda;


import ch08.rtda.Frame;
import ch08.rtda.Stack;
import ch08.rtda.heap.Method;
import org.joou.UInteger;

import static org.joou.Unsigned.uint;

public class Thread {
/*    package rtda
    type Thread struct {
        pc int
        stack *Stack
    }
    func NewThread() *Thread {...}
    func (self *Thread) PC() int { return self.pc } /
    func (self *Thread) SetPC(pc int) { self.pc = pc
        func (self *Thread) PushFrame(frame *Frame) {...}
        func (self *Thread) PopFrame() *Frame {...}
        func (self *Thread) CurrentFrame() *Frame {...}*/
    public int pc;
    public Stack stack;


    public int getPc(){
        return pc;
    }
    public void setPc(int pc){
        this.pc=pc;
    }

    public Thread(Stack stack) {
        this.stack = stack;
    }

    public static ch08.rtda.Thread newThread(){
   /*     func NewThread() *Thread {
            return new Thread{
                stack: newStack(1024),
            }
        }*/
        UInteger maxsize=uint(1024);
        return new ch08.rtda.Thread(Stack.newStack(maxsize));
    }

 /*   func (self *Thread) PushFrame(frame *Frame) {
        self.stack.push(frame)
    }
    func (self *Thread) PopFrame() *Frame {
        return self.stack.pop()
    }*/
    public void pushFrame(Frame frame){
        stack.push(frame);
    }

    public Frame popFrame(){
        return stack.pop();
    }

  /*  func (self *Thread) CurrentFrame() *Frame {
        return self.stack.top()
    }
*/
    public Frame currentFrame(){
        return stack.top();
    }

    public Frame topFrame(){
        return stack.top();
    }

    public Frame newFrame(Method method){
        return Frame.newFrame(this,method);
    }

    public boolean isStackEmpty(){
        return  this.stack.isEmpty();
    }
}
