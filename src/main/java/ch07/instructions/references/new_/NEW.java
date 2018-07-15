package ch07.instructions.references.new_;

import ch07.instructions.base.class_init_logic.InitClass;
import ch07.instructions.base.instruction.Index16Instruction;
import ch07.rtda.Frame;
import ch07.rtda.heap.Class;
import ch07.rtda.heap.ClassRef;
import ch07.rtda.heap.Object;
import ch07.rtda.heap.constant_pool.ConstantPool;

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

        if(!clazz.initStarted){
            frame.revertNextPC();
            InitClass.InitClass(frame.thread,clazz);
            return;
        }

        if(clazz.IsInterface()||clazz.IsAbstract()){
            System.out.println("java.lang.InstantiationError");
        }
        Object ref=clazz.newObject();
        frame.operandStack.pushRef(ref);
    }
}
