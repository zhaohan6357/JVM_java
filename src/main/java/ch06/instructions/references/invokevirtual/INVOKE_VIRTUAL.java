package ch06.instructions.references.invokevirtual;

import ch06.instructions.base.instruction.Index16Instruction;
import ch06.rtda.Frame;
import ch06.rtda.OperandStack;
import ch06.rtda.heap.MemberRef;
import ch06.rtda.heap.MethodRef;
import ch06.rtda.heap.constant_pool.ConstantPool;

public class INVOKE_VIRTUAL extends Index16Instruction {

    @Override
    public void Execute(Frame frame) {
        ConstantPool cp=frame.method.clazz.constantPool;
        MethodRef methodRef=(MethodRef)cp.getConstant(index).object;
        if(methodRef.name.equals("println")){
            OperandStack stack=frame.operandStack;
            switch (methodRef.descriptor){
                case "(Z)V":
                    System.out.println(stack.popInt() != 0);
                    break;
                case "(C)V":
                    System.out.println(stack.popInt());
                    break;
                case "(I)V": case "(B)V":case "(S)V":
                    System.out.println(stack.popInt());
                    break;
                case "(F)V":
                    System.out.println(stack.popFloat());
                    break;
                case "(J)V":
                    System.out.println(stack.popLong());
                    break;
                case "(D)V":
                    System.out.println(stack.popDouble());
                    break;
                default:
                    System.out.println("println: " +methodRef.descriptor);

            }
            stack.popRef();
        }
    }
}
