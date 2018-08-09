package ch09.instructions.control.table_switch;

import ch09.instructions.base.ByteCodeReader;
import ch09.instructions.base.branch_logic.branch_logic;
import ch09.instructions.base.instruction.Instruction;
import ch09.rtda.Frame;

public class TABLE_SWITCH extends Instruction{
 /*   type TABLE_SWITCH struct {
        defaultOffset int32
        low int32
        high int32
        jumpOffsets []int32
    }*/
    int defaultOffset;
    int low;
    int high;
    int[] jumpOffsets;

    @Override
    public void FetchOperands(ByteCodeReader reader) {
        reader.skipPadding();
        defaultOffset=reader.readInt32();
        low=reader.readInt32();
        high=reader.readInt32();
        int jumpOffsetsCount=high-low+1;
        jumpOffsets=reader.readInt32s(jumpOffsetsCount);

    }

    @Override
    public void Execute(Frame frame) {
        int index=frame.operandStack.popInt();
        int offset;
        if(index>=low&&index<=high){
            offset=jumpOffsets[index-low];
        }else{
            offset=defaultOffset;
        }
        branch_logic.Branch(frame,offset);
    }

   /* func (self *TABLE_SWITCH) FetchOperands(reader *base.BytecodeReader) {
        reader.SkipPadding()
        self.defaultOffset = reader.ReadInt32()
        self.low = reader.ReadInt32()
        self.high = reader.ReadInt32()
        jumpOffsetsCount := self.high - self.low + 1
        self.jumpOffsets = reader.ReadInt32s(jumpOffsetsCount)
    }


    func (self *TABLE_SWITCH) Execute(frame *rtda.Frame) {
        index := frame.OperandStack().PopInt()

        var offset int
        if index >= self.low && index <= self.high {
            offset = int(self.jumpOffsets[index-self.low])
        } else {
            offset = int(self.defaultOffset)
        }

        base.Branch(frame, offset)
    }*/

}
