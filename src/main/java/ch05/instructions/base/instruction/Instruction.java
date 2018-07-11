package ch05.instructions.base.instruction;

import ch05.rtda.Frame;
import ch05.instructions.base.ByteCodeReader;
import org.joou.UInteger;

public class Instruction {
    /*    type Instruction interface {
        FetchOperands(reader *BytecodeReader)
        Execute(frame *rtda.Frame)
    }*/
    public UInteger index;
    public int Const;
    public int offset;
    public void FetchOperands(ByteCodeReader reader){

    }
    public void Execute(Frame frame){

    }

}
