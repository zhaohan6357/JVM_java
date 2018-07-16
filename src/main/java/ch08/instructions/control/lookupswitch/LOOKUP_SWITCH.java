package ch08.instructions.control.lookupswitch;

import ch08.instructions.base.ByteCodeReader;
import ch08.instructions.base.branch_logic.branch_logic;
import ch08.instructions.base.instruction.Instruction;
import ch08.rtda.Frame;

public class LOOKUP_SWITCH extends Instruction{
   /* type LOOKUP_SWITCH struct {
        defaultOffset int32
        npairs        int32
        matchOffsets  []int32
    }*/
   int defaultOffset;
   int npairs;
   int[] matchOffsets;

    @Override
    public void FetchOperands(ByteCodeReader reader) {
        reader.skipPadding();
        defaultOffset=reader.readInt32();
        npairs=reader.readInt32();
        matchOffsets=reader.readInt32s(npairs*2);
    }

    @Override
    public void Execute(Frame frame) {
        int offset;
        int key=frame.operandStack.popInt();
        for(int i = 0;i<2*npairs;i+=2){
            if(matchOffsets[i]==key){
                offset=matchOffsets[i+1];
                branch_logic.Branch(frame,offset);
                return;
            }
        }
        branch_logic.Branch(frame,defaultOffset);
    }

   /* func (self *LOOKUP_SWITCH) FetchOperands(reader *base.BytecodeReader) {
        reader.SkipPadding()
        self.defaultOffset = reader.ReadInt32()
        self.npairs = reader.ReadInt32()
        self.matchOffsets = reader.ReadInt32s(self.npairs * 2)
    }

    func (self *LOOKUP_SWITCH) Execute(frame *rtda.Frame) {
        key := frame.OperandStack().PopInt()
        for i := int32(0); i < self.npairs*2; i += 2 {
            if self.matchOffsets[i] == key {
                offset := self.matchOffsets[i+1]
                base.Branch(frame, int(offset))
                return
            }
        }
        base.Branch(frame, int(self.defaultOffset))
    }*/
}
