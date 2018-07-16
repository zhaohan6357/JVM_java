package ch08.instructions.factory;

import ch08.instructions.base.instruction.Instruction;
import ch08.instructions.comparisons.dcmp.DCMPG;
import ch08.instructions.comparisons.dcmp.DCMPL;
import ch08.instructions.comparisons.fcmp.FCMPG;
import ch08.instructions.comparisons.fcmp.FCMPL;
import ch08.instructions.comparisons.if_acmp.IF_ACMPEQ;
import ch08.instructions.comparisons.if_acmp.IF_ACMPNE;
import ch08.instructions.comparisons.lcmp.LCMP;
import ch08.instructions.constants.const_.*;
import ch08.instructions.constants.ipush.BIPUSH;
import ch08.instructions.constants.ipush.SIPUSH;
import ch08.instructions.constants.ldc.LDC;
import ch08.instructions.constants.ldc.LDC2_W;
import ch08.instructions.constants.ldc.LDC_W;
import ch08.instructions.constants.nop.NOP;
import ch08.instructions.control.goto_.GOTO;
import ch08.instructions.control.lookupswitch.LOOKUP_SWITCH;
import ch08.instructions.control.return_.*;
import ch08.instructions.control.table_switch.TABLE_SWITCH;
import ch08.instructions.conversions.d2x.D2F;
import ch08.instructions.conversions.d2x.D2I;
import ch08.instructions.conversions.d2x.D2L;
import ch08.instructions.conversions.f2x.F2D;
import ch08.instructions.conversions.f2x.F2I;
import ch08.instructions.conversions.f2x.F2L;
import ch08.instructions.conversions.i2x.*;
import ch08.instructions.conversions.l2x.L2D;
import ch08.instructions.conversions.l2x.L2F;
import ch08.instructions.conversions.l2x.L2I;
import ch08.instructions.extended.goto_w.GOTO_W;
import ch08.instructions.extended.ifnull.IFNONNULL;
import ch08.instructions.extended.ifnull.IFNULL;
import ch08.instructions.extended.wide.WIDE;
import ch08.instructions.loads.aload.*;
import ch08.instructions.loads.dload.*;
import ch08.instructions.loads.fload.*;
import ch08.instructions.loads.iload.*;
import ch08.instructions.loads.lload.*;
import ch08.instructions.math.add.DADD;
import ch08.instructions.math.add.FADD;
import ch08.instructions.math.add.IADD;
import ch08.instructions.math.add.LADD;
import ch08.instructions.math.and.IAND;
import ch08.instructions.math.and.LAND;
import ch08.instructions.math.div.DDIV;
import ch08.instructions.math.div.FDIV;
import ch08.instructions.math.div.IDIV;
import ch08.instructions.math.div.LDIV;
import ch08.instructions.math.iinc.IINC;
import ch08.instructions.math.mul.DMUL;
import ch08.instructions.math.mul.FMUL;
import ch08.instructions.math.mul.IMUL;
import ch08.instructions.math.mul.LMUL;
import ch08.instructions.math.neg.DNEG;
import ch08.instructions.math.neg.FNEG;
import ch08.instructions.math.neg.INEG;
import ch08.instructions.math.neg.LNEG;
import ch08.instructions.math.or.IOR;
import ch08.instructions.math.or.LOR;
import ch08.instructions.math.rem.DREM;
import ch08.instructions.math.rem.FREM;
import ch08.instructions.math.rem.IREM;
import ch08.instructions.math.rem.LREM;
import ch08.instructions.math.sh.*;
import ch08.instructions.math.sub.DSUB;
import ch08.instructions.math.sub.FSUB;
import ch08.instructions.math.sub.ISUB;
import ch08.instructions.math.sub.LSUB;
import ch08.instructions.math.xor.IXOR;
import ch08.instructions.math.xor.LXOR;
import ch08.instructions.references.checkcast.CHECK_CAST;
import ch08.instructions.references.getfield.GET_FIELD;
import ch08.instructions.references.getstatic.GET_STATIC;
import ch08.instructions.references.instanceof_.INSTANCE_OF;
import ch08.instructions.references.invokeinterface.INVOKE_INTERFACE;
import ch08.instructions.references.invokespecial.INVOKE_SPECIAL;
import ch08.instructions.references.invokestatic.INVOKE_STATIC;
import ch08.instructions.references.invokevirtual.INVOKE_VIRTUAL;
import ch08.instructions.references.new_.NEW;
import ch08.instructions.references.putfield.PUT_FIELD;
import ch08.instructions.references.putstatic.PUT_STATIC;
import ch08.instructions.stack.dup.*;
import ch08.instructions.stack.pop.POP;
import ch08.instructions.stack.pop.POP2;
import ch08.instructions.stack.swap.SWAP;
import ch08.instructions.stores.astore.*;
import ch08.instructions.stores.dstore.*;
import ch08.instructions.stores.fstore.*;
import ch08.instructions.stores.istore.*;
import ch08.instructions.stores.lscore.*;
import ch08.instructions.comparisons.if_icmp.*;
import ch08.instructions.comparisons.ifcond.*;
import org.joou.UByte;

public class Factory {

   public static Instruction nop         = new NOP();
   public static Instruction aconst_null = new ACONST_NULL();
   public static Instruction iconst_m1   = new ICONST_M1();
   public static Instruction iconst_0    = new ICONST_0();
   public static Instruction iconst_1    = new ICONST_1();
   public static Instruction iconst_2    = new ICONST_2();
   public static Instruction iconst_3    = new ICONST_3();
   public static Instruction iconst_4    = new ICONST_4();
   public static Instruction iconst_5    = new ICONST_5();
   public static Instruction lconst_0    = new LCONST_0();
   public static Instruction lconst_1    = new LCONST_1();
   public static Instruction fconst_0    = new FCONST_0();
   public static Instruction fconst_1    = new FCONST_1();
   public static Instruction fconst_2    = new FCONST_2();
   public static Instruction dconst_0    = new DCONST_0();
   public static Instruction dconst_1    = new DCONST_1();
   public static Instruction iload_0     = new ILOAD_0();
   public static Instruction iload_1     = new ILOAD_1();
   public static Instruction iload_2     = new ILOAD_2();
   public static Instruction iload_3     = new ILOAD_3();
   public static Instruction lload_0     = new LLOAD_0();
   public static Instruction lload_1     = new LLOAD_1();
   public static Instruction lload_2     = new LLOAD_2();
   public static Instruction lload_3     = new LLOAD_3();
   public static Instruction fload_0     = new FLOAD_0();
   public static Instruction fload_1     = new FLOAD_1();
   public static Instruction fload_2     = new FLOAD_2();
   public static Instruction fload_3     = new FLOAD_3();
   public static Instruction dload_0     = new DLOAD_0();
   public static Instruction dload_1     = new DLOAD_1();
   public static Instruction dload_2     = new DLOAD_2();
   public static Instruction dload_3     = new DLOAD_3();
   public static Instruction aload_0     = new ALOAD_0();
   public static Instruction aload_1     = new ALOAD_1();
   public static Instruction aload_2     = new ALOAD_2();
   public static Instruction aload_3     = new ALOAD_3();
    // public static Instruction iaload      = new IALOAD();
    // public static Instruction laload      = new LALOAD();
    // public static Instruction faload      = new FALOAD();
    // public static Instruction daload      = new DALOAD();
    // public static Instruction aaload      = new AALOAD();
    // public static Instruction baload      = new BALOAD();
    // public static Instruction caload      = new CALOAD();
    // public static Instruction saload      = new SALOAD();
    public static Instruction istore_0 = new ISTORE_0();
    public static Instruction istore_1 = new ISTORE_1();
    public static Instruction istore_2 = new ISTORE_2();
    public static Instruction istore_3 = new ISTORE_3();
    public static Instruction lstore_0 = new LSTORE_0();
    public static Instruction lstore_1 = new LSTORE_1();
    public static Instruction lstore_2 = new LSTORE_2();
    public static Instruction lstore_3 = new LSTORE_3();
    public static Instruction fstore_0 = new FSTORE_0();
    public static Instruction fstore_1 = new FSTORE_1();
    public static Instruction fstore_2 = new FSTORE_2();
    public static Instruction fstore_3 = new FSTORE_3();
    public static Instruction dstore_0 = new DSTORE_0();
    public static Instruction dstore_1 = new DSTORE_1();
    public static Instruction dstore_2 = new DSTORE_2();
    public static Instruction dstore_3 = new DSTORE_3();
    public static Instruction astore_0 = new ASTORE_0();
    public static Instruction astore_1 = new ASTORE_1();
    public static Instruction astore_2 = new ASTORE_2();
    public static Instruction astore_3 = new ASTORE_3();
    // public static Instruction iastore  = new IASTORE();
    // public static Instruction lastore  = new LASTORE();
    // public static Instruction fastore  = new FASTORE();
    // public static Instruction dastore  = new DASTORE();
    // public static Instruction aastore  = new AASTORE();
    // public static Instruction bastore  = new BASTORE();
    // public static Instruction castore  = new CASTORE();
    // public static Instruction sastore  = new SASTORE();
    public static Instruction pop     = new POP();
    public static Instruction pop2    = new POP2();
    public static Instruction dup     = new DUP();
    public static Instruction dup_x1  = new DUP_X1();
    public static Instruction dup_x2  = new DUP_X2();
    public static Instruction dup2    = new DUP2();
    public static Instruction dup2_x1 = new DUP2_X1();
    public static Instruction dup2_x2 = new DUP2_X2();
    public static Instruction swap    = new SWAP();
    public static Instruction iadd    = new IADD();
    public static Instruction ladd    = new LADD();
    public static Instruction fadd    = new FADD();
    public static Instruction dadd    = new DADD();
    public static Instruction isub    = new ISUB();
    public static Instruction lsub    = new LSUB();
    public static Instruction fsub    = new FSUB();
    public static Instruction dsub    = new DSUB();
    public static Instruction imul    = new IMUL();
    public static Instruction lmul    = new LMUL();
    public static Instruction fmul    = new FMUL();
    public static Instruction dmul    = new DMUL();
    public static Instruction idiv    = new IDIV();
    public static Instruction ldiv    = new LDIV();
    public static Instruction fdiv    = new FDIV();
    public static Instruction ddiv    = new DDIV();
    public static Instruction irem    = new IREM();
    public static Instruction lrem    = new LREM();
    public static Instruction frem    = new FREM();
    public static Instruction drem    = new DREM();
    public static Instruction ineg    = new INEG();
    public static Instruction lneg    = new LNEG();
    public static Instruction fneg    = new FNEG();
    public static Instruction dneg    = new DNEG();
    public static Instruction ishl    = new ISHL();
    public static Instruction lshl    = new LSHL();
    public static Instruction ishr    = new ISHR();
    public static Instruction lshr    = new LSHR();
    public static Instruction iushr   = new IUSHR();
    public static Instruction lushr   = new LUSHR();
    public static Instruction iand    = new IAND();
    public static Instruction land    = new LAND();
    public static Instruction ior     = new IOR();
    public static Instruction lor     = new LOR();
    public static Instruction ixor    = new IXOR();
    public static Instruction lxor    = new LXOR();
    public static Instruction i2l     = new I2L();
    public static Instruction i2f     = new I2F();
    public static Instruction i2d     = new I2D();
    public static Instruction l2i     = new L2I();
    public static Instruction l2f     = new L2F();
    public static Instruction l2d     = new L2D();
    public static Instruction f2i     = new F2I();
    public static Instruction f2l     = new F2L();
    public static Instruction f2d     = new F2D();
    public static Instruction d2i     = new D2I();
    public static Instruction d2l     = new D2L();
    public static Instruction d2f     = new D2F();
    public static Instruction i2b     = new I2B();
    public static Instruction i2c     = new I2C();
    public static Instruction i2s     = new I2S();
    public static Instruction lcmp    = new LCMP();
    public static Instruction fcmpl   = new FCMPL();
    public static Instruction fcmpg   = new FCMPG();
    public static Instruction dcmpl   = new DCMPL();
    public static Instruction dcmpg   = new DCMPG();
     public static Instruction ireturn = new IRETURN();
     public static Instruction lreturn = new LRETURN();
     public static Instruction freturn = new FRETURN();
     public static Instruction dreturn = new DRETURN();
     public static Instruction areturn = new ARETURN();
     public static Instruction _return = new RETURN();
    // public static Instruction arraylength   = new ARRAY_LENGTH();
    // public static Instruction athrow        = new ATHROW();
    // public static Instruction monitorenter  = new MONITOR_ENTER();
    // public static Instruction monitorexit   = new MONITOR_EXIT();
    // public static Instruction invoke_native = new INVOKE_NATIVE();


    public static Instruction newInstruction(UByte opcode){
        switch (opcode.intValue()) {
            case 0x00:
                return nop;
            case 0x01:
                return aconst_null;
            case 0x02:
                return iconst_m1;
            case 0x03:
                return iconst_0;
            case 0x04:
                return iconst_1;
            case 0x05:
                return iconst_2;
            case 0x06:
                return iconst_3;
            case 0x07:
                return iconst_4;
            case 0x08:
                return iconst_5;
            case 0x09:
                return lconst_0;
            case 0x0a:
                return lconst_1;
            case 0x0b:
                return fconst_0;
            case 0x0c:
                return fconst_1;
            case 0x0d:
                return fconst_2;
            case 0x0e:
                return dconst_0;
            case 0x0f:
                return dconst_1;
            case 0x10:
                return new BIPUSH();
            case 0x11:
                return new SIPUSH();
             case 0x12:
             	return new LDC();
             case 0x13:
             	return new LDC_W();
             case 0x14:
             	return new LDC2_W();
            case 0x15:
                return new ILOAD();
            case 0x16:
                return new LLOAD();
            case 0x17:
                return new FLOAD();
            case 0x18:
                return new DLOAD();
            case 0x19:
                return new ALOAD();
            case 0x1a:
                return iload_0;
            case 0x1b:
                return iload_1;
            case 0x1c:
                return iload_2;
            case 0x1d:
                return iload_3;
            case 0x1e:
                return lload_0;
            case 0x1f:
                return lload_1;
            case 0x20:
                return lload_2;
            case 0x21:
                return lload_3;
            case 0x22:
                return fload_0;
            case 0x23:
                return fload_1;
            case 0x24:
                return fload_2;
            case 0x25:
                return fload_3;
            case 0x26:
                return dload_0;
            case 0x27:
                return dload_1;
            case 0x28:
                return dload_2;
            case 0x29:
                return dload_3;
            case 0x2a:
                return aload_0;
            case 0x2b:
                return aload_1;
            case 0x2c:
                return aload_2;
            case 0x2d:
                return aload_3;
            // case 0x2e:
            // 	return iaload
            // case 0x2f:
            // 	return laload
            // case 0x30:
            // 	return faload
            // case 0x31:
            // 	return daload
            // case 0x32:
            // 	return aaload
            // case 0x33:
            // 	return baload
            // case 0x34:
            // 	return caload
            // case 0x35:
            // 	return saload
            case 0x36:
                return new ISTORE();
            case 0x37:
                return new LSTORE();
            case 0x38:
                return new FSTORE();
            case 0x39:
                return new DSTORE();
            case 0x3a:
                return new ASTORE();
            case 0x3b:
                return istore_0;
            case 0x3c:
                return istore_1;
            case 0x3d:
                return istore_2;
            case 0x3e:
                return istore_3;
            case 0x3f:
                return lstore_0;
            case 0x40:
                return lstore_1;
            case 0x41:
                return lstore_2;
            case 0x42:
                return lstore_3;
            case 0x43:
                return fstore_0;
            case 0x44:
                return fstore_1;
            case 0x45:
                return fstore_2;
            case 0x46:
                return fstore_3;
            case 0x47:
                return dstore_0;
            case 0x48:
                return dstore_1;
            case 0x49:
                return dstore_2;
            case 0x4a:
                return dstore_3;
            case 0x4b:
                return astore_0;
            case 0x4c:
                return astore_1;
            case 0x4d:
                return astore_2;
            case 0x4e:
                return astore_3;
            // case 0x4f:
            // 	return iastore;
            // case 0x50:
            // 	return lastore;
            // case 0x51:
            // 	return fastore;
            // case 0x52:
            // 	return dastore;
            // case 0x53:
            // 	return aastore;
            // case 0x54:
            // 	return bastore;
            // case 0x55:
            // 	return castore;
            // case 0x56:
            // 	return sastore;
            case 0x57:
                return pop;
            case 0x58:
                return pop2;
            case 0x59:
                return dup;
            case 0x5a:
                return dup_x1;
            case 0x5b:
                return dup_x2;
            case 0x5c:
                return dup2;
            case 0x5d:
                return dup2_x1;
            case 0x5e:
                return dup2_x2;
            case 0x5f:
                return swap;
            case 0x60:
                return iadd;
            case 0x61:
                return ladd;
            case 0x62:
                return fadd;
            case 0x63:
                return dadd;
            case 0x64:
                return isub;
            case 0x65:
                return lsub;
            case 0x66:
                return fsub;
            case 0x67:
                return dsub;
            case 0x68:
                return imul;
            case 0x69:
                return lmul;
            case 0x6a:
                return fmul;
            case 0x6b:
                return dmul;
            case 0x6c:
                return idiv;
            case 0x6d:
                return ldiv;
            case 0x6e:
                return fdiv;
            case 0x6f:
                return ddiv;
            case 0x70:
                return irem;
            case 0x71:
                return lrem;
            case 0x72:
                return frem;
            case 0x73:
                return drem;
            case 0x74:
                return ineg;
            case 0x75:
                return lneg;
            case 0x76:
                return fneg;
            case 0x77:
                return dneg;
            case 0x78:
                return ishl;
            case 0x79:
                return lshl;
            case 0x7a:
                return ishr;
            case 0x7b:
                return lshr;
            case 0x7c:
                return iushr;
            case 0x7d:
                return lushr;
            case 0x7e:
                return iand;
            case 0x7f:
                return land;
            case 0x80:
                return ior;
            case 0x81:
                return lor;
            case 0x82:
                return ixor;
            case 0x83:
                return lxor;
            case 0x84:
                return new IINC();
            case 0x85:
                return i2l;
            case 0x86:
                return i2f;
            case 0x87:
                return i2d;
            case 0x88:
                return l2i;
            case 0x89:
                return l2f;
            case 0x8a:
                return l2d;
            case 0x8b:
                return f2i;
            case 0x8c:
                return f2l;
            case 0x8d:
                return f2d;
            case 0x8e:
                return d2i;
            case 0x8f:
                return d2l;
            case 0x90:
                return d2f;
            case 0x91:
                return i2b;
            case 0x92:
                return i2c;
            case 0x93:
                return i2s;
            case 0x94:
                return lcmp;
            case 0x95:
                return fcmpl;
            case 0x96:
                return fcmpg;
            case 0x97:
                return dcmpl;
            case 0x98:
                return dcmpg;
            case 0x99:
                return new IFEQ();
            case 0x9a:
                return new IFNE();
            case 0x9b:
                return new IFLT();
            case 0x9c:
                return new IFGE();
            case 0x9d:
                return new IFGT();
            case 0x9e:
                return new IFLE();
            case 0x9f:
                return new IF_ICMPEQ();
            case 0xa0:
                return new IF_ICMPNE();
            case 0xa1:
                return new IF_ICMPLT();
            case 0xa2:
                return new IF_ICMPGE();
            case 0xa3:
                return new IF_ICMPGT();
            case 0xa4:
                return new IF_ICMPLE();
            case 0xa5:
                return new IF_ACMPEQ();
            case 0xa6:
                return new IF_ACMPNE();
            case 0xa7:
                return new GOTO();
            // case 0xa8:
            // 	return new JSR();
            // case 0xa9:
            // 	return new RET();
            case 0xaa:
                return new TABLE_SWITCH();
            case 0xab:
                return new LOOKUP_SWITCH();
             case 0xac:
             	return ireturn;
             case 0xad:
             	return lreturn;
             case 0xae:
             	return freturn;
             case 0xaf:
             	return dreturn;
             case 0xb0:
             	return areturn;
             case 0xb1:
             	return _return;
            	case 0xb2:
            		return new GET_STATIC();
             case 0xb3:
             	return new PUT_STATIC();
             case 0xb4:
             	return new GET_FIELD();
             case 0xb5:
             	return new PUT_FIELD();
            	case 0xb6:
            		return new INVOKE_VIRTUAL();
             case 0xb7:
             	return new INVOKE_SPECIAL();
             case 0xb8:
             	return new INVOKE_STATIC();
             case 0xb9:
             	return new INVOKE_INTERFACE();
            // case 0xba:
            // 	return new INVOKE_DYNAMIC();
             case 0xbb:
             	return new NEW();
            // case 0xbc:
            // 	return new NEW_ARRAY();
            // case 0xbd:
            // 	return new ANEW_ARRAY();
            // case 0xbe:
            // 	return arraylength
            // case 0xbf:
            // 	return athrow
             case 0xc0:
             	return new CHECK_CAST();
             case 0xc1:
             	return new INSTANCE_OF();
            // case 0xc2:
            // 	return monitorenter
            // case 0xc3:
            // 	return monitorexit
            case 0xc4:
                return new WIDE();
            // case 0xc5:
            // 	return new MULTI_ANEW_ARRAY();
            case 0xc6:
                return new IFNULL();
            case 0xc7:
                return new IFNONNULL();
            case 0xc8:
                return new GOTO_W();
            // case 0xc9:
            // 	return new JSR_W();
            // case 0xca: breakpoint
            // case 0xfe: impdep1
            // case 0xff: impdep2
            default:{
                System.out.println("Unsupported opcode");
                return null;
            }
        }

    }
}
