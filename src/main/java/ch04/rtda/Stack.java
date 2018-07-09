package ch04.rtda;

import org.joou.UInteger;

import static org.joou.Unsigned.uint;

public class Stack {
    /*    type Stack struct {
            maxSize uint
            size uint
            _top *Frame
        }
        func newStack(maxSize uint) *Stack {...}
        func (self *Stack) push(frame *Frame) {...}
        func (self *Stack) pop() *Frame {...}
        func (self *Stack) top() *Frame {...}*/
    UInteger maxSie;
    UInteger size = uint(0);
    Frame _top;

    /*    func newStack(maxSize uint) *Stack {
            return &Stack{
                maxSize: maxSize,
            }
        }*/
    public static Stack newStack(UInteger maxSie) {
        return new Stack(maxSie);
    }

    /*
        func (self *Stack) push(frame *Frame) {
            if self.size >= self.maxSize {
                panic("java.lang.StackOverflowError")
            }
            if self._top != nil {
                frame.lower = self._top
            }
            self._top = frame
            self.size++
        }*/
    public void push(Frame frame) {
        if (size.longValue() >= maxSie.longValue()) {
            System.out.println("java.lang.StackOverFlowError");
            return;
        }
        if (_top != null) {
            frame.lower = _top;
        }
        _top = frame;
        size = size.add(1);
    }

    /*    func (self *Stack) pop() *Frame {
            if self._top == nil {
                panic("jvm stack is empty!")
            }
            top := self._top
            self._top = top.lower
            top.lower = nil
            self.size--
            return top
        }*/
    public Frame pop() {
        if (this._top != null) {
            System.out.println("jvm stack is empty");
            return null;
        }
        Frame top = this._top;
        this._top = top.lower;
        top.lower = null;
        size = size.subtract(1);
        return top;
    }

    /*    func (self *Stack) top() *Frame {
            if self._top == nil {
                panic("jvm stack is empty!")
            }
            return self._top
        }*/
    public Frame top() {
        if (this._top == null) {
            System.out.println("jvm stack is empty!");
            return null;
        }
        return this._top;
    }

    public Stack(UInteger maxSie) {
        this.size = uint(0);
        this.maxSie = maxSie;
    }
}
