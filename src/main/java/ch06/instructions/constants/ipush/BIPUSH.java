package ch06.instructions.constants.ipush;

import ch06.rtda.Frame;
import ch06.instructions.base.ByteCodeReader;
import ch06.instructions.base.instruction.Instruction;
import ch06.instructions.base.instruction.NoOperandsInstruction;

public class BIPUSH extends Instruction{

/*    // Push byte
    type BIPUSH struct {
        val int8
    }

    func (self *BIPUSH) FetchOperands(reader *base.BytecodeReader) {
        self.val = reader.ReadInt8()
    }
    func (self *BIPUSH) Execute(frame *rtda.Frame) {
        i := int32(self.val)
        frame.OperandStack().PushInt(i)
    }*/
    byte val;

    @Override
    public void FetchOperands(ByteCodeReader reader) {
        this.val=reader.readInt8();
    }

    @Override
    public void Execute(Frame frame) {
        int i=(int)val;
        frame.operandStack.pushInt(i);
    }
}
