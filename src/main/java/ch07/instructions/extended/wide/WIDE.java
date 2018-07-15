package ch07.instructions.extended.wide;

import ch07.instructions.base.ByteCodeReader;
import ch07.instructions.base.instruction.Instruction;
import ch07.instructions.loads.aload.ALOAD;
import ch07.instructions.loads.dload.DLOAD;
import ch07.instructions.loads.fload.FLOAD;
import ch07.instructions.loads.iload.ILOAD;
import ch07.instructions.loads.lload.LLOAD;
import ch07.instructions.math.iinc.IINC;
import ch07.instructions.stores.astore.ASTORE;
import ch07.instructions.stores.dstore.DSTORE;
import ch07.instructions.stores.fstore.FSTORE;
import ch07.instructions.stores.istore.ISTORE;
import ch07.instructions.stores.lscore.LSTORE;
import ch07.rtda.Frame;
import org.joou.UByte;
import org.joou.UInteger;

import javax.sound.midi.Soundbank;

public class WIDE extends Instruction {
    /*// Extend local variable index by additional bytes
    type WIDE; struct {
        modifiedInstruction base.Instruction
    }*/

    Instruction modifiedInstruction;

    @Override
    public void FetchOperands(ByteCodeReader reader) {
        Instruction inst=new Instruction();
        UByte op = reader.readUint8();
        int opcode=op.intValue();
        switch (opcode)
        {
            case 0x15:{
                modifiedInstruction= new ILOAD();
                modifiedInstruction.index= UInteger.valueOf(reader.readUInt16().intValue());
                return;
            }
            case 0x16:{
                modifiedInstruction= new LLOAD();
                modifiedInstruction.index= UInteger.valueOf(reader.readUInt16().intValue());
                return;
            }
            case 0x17:{
                modifiedInstruction= new FLOAD();
                modifiedInstruction.index= UInteger.valueOf(reader.readUInt16().intValue());
                return;
            }
            case 0x18:{
                modifiedInstruction= new DLOAD();
                modifiedInstruction.index= UInteger.valueOf(reader.readUInt16().intValue());
                return;
            }
            case 0x19:{
                modifiedInstruction= new ALOAD();
                modifiedInstruction.index= UInteger.valueOf(reader.readUInt16().intValue());
                return;
            }
            case 0x36:{
                modifiedInstruction= new ISTORE();
                modifiedInstruction.index= UInteger.valueOf(reader.readUInt16().intValue());
                return;
            }
            case 0x37:{
                modifiedInstruction= new LSTORE();
                modifiedInstruction.index= UInteger.valueOf(reader.readUInt16().intValue());
                return;
            }
            case 0x38:{
                modifiedInstruction= new FSTORE();
                modifiedInstruction.index= UInteger.valueOf(reader.readUInt16().intValue());
                return;
            }
            case 0x39:{
                modifiedInstruction= new DSTORE();
                modifiedInstruction.index= UInteger.valueOf(reader.readUInt16().intValue());
                return;
            }
            case 0x3A:{
                modifiedInstruction= new ASTORE();
                modifiedInstruction.index= UInteger.valueOf(reader.readUInt16().intValue());
                return;
            }
            case 0x84:{
                modifiedInstruction= new IINC();
                modifiedInstruction.index= UInteger.valueOf(reader.readUInt16().intValue());
                modifiedInstruction.Const= reader.readInt16();
                return;
            }
            case 0xa9: // ret
                System.out.println("Unsupported opcode: 0xa9!");
                System.exit(1);
        }
    }


    @Override
    public void Execute(Frame frame) {
        modifiedInstruction.Execute(frame);
    }

}
