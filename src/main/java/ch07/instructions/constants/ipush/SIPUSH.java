package ch07.instructions.constants.ipush;

import ch07.rtda.Frame;
import ch07.instructions.base.ByteCodeReader;
import ch07.instructions.base.instruction.Instruction;

public class SIPUSH extends Instruction {
/*
    // Push short
    type SIPUSH struct {
        val int16
    }

    func (self *SIPUSH) FetchOperands(reader *base.BytecodeReader) {
        self.val = reader.ReadInt16()
    }
    func (self *SIPUSH) Execute(frame *rtda.Frame) {
        i := int32(self.val)
        frame.OperandStack().PushInt(i)
    }*/
    short val;

    @Override
    public void FetchOperands(ByteCodeReader reader) {
        val=reader.readInt16();
    }

    @Override
    public void Execute(Frame frame) {
        int i=(int)val;
        frame.operandStack.pushInt(i);
    }
}
