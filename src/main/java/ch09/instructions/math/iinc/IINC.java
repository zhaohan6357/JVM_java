package ch09.instructions.math.iinc;

import ch09.instructions.base.ByteCodeReader;
import ch09.instructions.base.instruction.Instruction;
import ch09.rtda.Frame;
import org.joou.UInteger;

public class IINC extends Instruction{
    // Increment local variable by constant
/*    type IINC struct {
        Index uint
        Const int32
    }

    func (self *IINC) FetchOperands(reader *base.BytecodeReader) {
        self.Index = uint(reader.ReadUint8())
        self.Const = int32(reader.ReadInt8())
    }

    func (self *IINC) Execute(frame *rtda.Frame) {
        localVars := frame.LocalVars()
        val := localVars.GetInt(self.Index)
        val += self.Const
        localVars.SetInt(self.Index, val)
    }*/



    @Override
    public void FetchOperands(ByteCodeReader reader) {
        int i=reader.readUint8().intValue();
        index=UInteger.valueOf(i);
        Const=(int)(reader.readInt8());
    }

    @Override
    public void Execute(Frame frame) {
       int val=frame.localVars.getInt(index);
       val+=Const;
       frame.localVars.setInt(index,val);
    }
}
