package ch06.instructions.references.new_;

import ch06.instructions.base.instruction.Index16Instruction;
import ch06.rtda.Frame;
import ch06.rtda.heap.Class;
import ch06.rtda.heap.ClassRef;
import ch06.rtda.heap.Object;
import ch06.rtda.heap.constant_pool.ConstantPool;

public class NEW extends Index16Instruction {
/*    func (self *NEW) Execute(frame *rtda.Frame) {
        cp := frame.Method().Class().ConstantPool()
        classRef := cp.GetConstant(self.Index).(*heap.ClassRef)
        class := classRef.ResolvedClass()
        // todo: init class

        if class.IsInterface() || class.IsAbstract() {
            panic("java.lang.InstantiationError")
        }

        ref := class.NewObject()
        frame.OperandStack().PushRef(ref)
    }*/

    @Override
    public void Execute(Frame frame) {
        ConstantPool cp=frame.method.clazz.constantPool;
        ClassRef classRef=(ClassRef)cp.getConstant(index).object;
        Class clazz=classRef.ResolvedClass();
        //todo:init class
        if(clazz.IsInterface()||clazz.IsAbstract()){
            System.out.println("java.lang.InstantiationError");
        }
        Object ref=clazz.newObject();
        frame.operandStack.pushRef(ref);
    }
}
