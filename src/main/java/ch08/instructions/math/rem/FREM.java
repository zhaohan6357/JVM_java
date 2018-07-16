package ch08.instructions.math.rem;

import ch08.instructions.base.instruction.NoOperandsInstruction;
import ch08.rtda.Frame;

public class FREM extends NoOperandsInstruction{
/*    type FREM struct{ base.NoOperandsInstruction }

    func (self *FREM) Execute(frame *rtda.Frame) {
        stack := frame.OperandStack()
        v2 := stack.PopFloat()
        v1 := stack.PopFloat()
        result := float32(math.Mod(float64(v1), float64(v2))) // todo
        stack.PushFloat(result)
    }*/

    @Override
    public void Execute(Frame frame) {
        float v2=frame.operandStack.popFloat();
        float v1=frame.operandStack.popFloat();
        float result=v1%v2;
        frame.operandStack.pushFloat(result);
    }
}
