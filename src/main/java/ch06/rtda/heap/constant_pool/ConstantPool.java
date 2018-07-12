package ch06.rtda.heap.constant_pool;

import ch06.classfile.*;
import ch06.rtda.heap.*;
import ch06.rtda.heap.Class;

public class ConstantPool {
    Class clazz;
    Constant[] consts;

    public static ConstantPool newConstantPool(Class clazz, ch06.classfile.ConstantPool cfCp) {
        int cpCount = cfCp.constantPool.length;
        Constant[] consts = new Constant[cpCount];
        ConstantPool constantPool = new ConstantPool();
        constantPool.clazz = clazz;
        constantPool.consts = consts;
        for (int i = 1; i < cpCount; i++) {
            ConstantInfo cpInfo = cfCp.constantPool[i];
            if (cpInfo.getClass() == ConstantIntegerInfo.class) {
                ConstantIntegerInfo integerInfo = (ConstantIntegerInfo) cpInfo;
                consts[i].object=integerInfo.val;
            } else if (cpInfo.getClass() == ConstantFloatInfo.class) {
                ConstantFloatInfo constantFloatInfo = (ConstantFloatInfo) cpInfo;
                consts[i].object=constantFloatInfo.val;
            } else if (cpInfo.getClass() == ConstantLongInfo.class) {
                ConstantLongInfo constantLongInfo = (ConstantLongInfo) cpInfo;
                consts[i].object=constantLongInfo.val;
            } else if (cpInfo.getClass() == ConstantDoubleInfo.class) {
                ConstantDoubleInfo constantDoubleInfo=(ConstantDoubleInfo)cpInfo;
                consts[i].object=constantDoubleInfo.val;
            } else if (cpInfo.getClass() == ConstantStringInfo.class) {
                ConstantStringInfo constantStringInfo= (ConstantStringInfo)cpInfo;
                consts[i].object= constantStringInfo.getString();
            } else if (cpInfo.getClass() == ConstantClassInfo.class) {
                ConstantClassInfo constantClassInfo= (ConstantClassInfo)cpInfo;
                consts[i].object= ClassRef.newClassRef(constantPool,constantClassInfo);
            } else if (cpInfo.getClass() == ConstantFieldrefInfo.class) {
                ConstantFieldrefInfo constantFieldrefInfo= (ConstantFieldrefInfo)cpInfo;
                consts[i].object= FieldRef.newFieldRef(constantPool,constantFieldrefInfo);
            } else if (cpInfo.getClass() == ConstantMethodrefInfo.class) {
                ConstantMethodrefInfo constantMethodrefInfo= (ConstantMethodrefInfo)cpInfo;
                consts[i].object= MethodRef.newMethodRef(constantPool,constantMethodrefInfo);
            } else if (cpInfo.getClass() == ConstantInterfaceMethodrefInfo.class) {
                ConstantInterfaceMethodrefInfo constantInterfaceMethodrefInfo= (ConstantInterfaceMethodrefInfo)cpInfo;
                consts[i].object=InterfaceMethodRef.newInterfaceMethodRef(constantPool,constantInterfaceMethodrefInfo);
            } else {
            }
        }
        return constantPool;
    }
    /*
        for i := 1; i < cpCount; i++ {
            cpInfo := cfCp[i]
            switch cpInfo.(type) {
		case *classfile.ConstantIntegerInfo:
            intInfo := cpInfo.(*classfile.ConstantIntegerInfo)
            consts[i] = intInfo.Value()
		case *classfile.ConstantFloatInfo:
            floatInfo := cpInfo.(*classfile.ConstantFloatInfo)
            consts[i] = floatInfo.Value()
		case *classfile.ConstantLongInfo:
            longInfo := cpInfo.(*classfile.ConstantLongInfo)
            consts[i] = longInfo.Value()
            i++
		case *classfile.ConstantDoubleInfo:
            doubleInfo := cpInfo.(*classfile.ConstantDoubleInfo)
            consts[i] = doubleInfo.Value()
            i++
		case *classfile.ConstantStringInfo:
            stringInfo := cpInfo.(*classfile.ConstantStringInfo)
            consts[i] = stringInfo.String()
		case *classfile.ConstantClassInfo:
            classInfo := cpInfo.(*classfile.ConstantClassInfo)
            consts[i] = newClassRef(rtCp, classInfo)
		case *classfile.ConstantFieldrefInfo:
            fieldrefInfo := cpInfo.(*classfile.ConstantFieldrefInfo)
            consts[i] = newFieldRef(rtCp, fieldrefInfo)
		case *classfile.ConstantMethodrefInfo:
            methodrefInfo := cpInfo.(*classfile.ConstantMethodrefInfo)
            consts[i] = newMethodRef(rtCp, methodrefInfo)
		case *classfile.ConstantInterfaceMethodrefInfo:
            methodrefInfo := cpInfo.(*classfile.ConstantInterfaceMethodrefInfo)
            consts[i] = newInterfaceMethodRef(rtCp, methodrefInfo)
            default:
                // todo
		}
        }

        return rtCp
    }

    func (self *ConstantPool) GetConstant(index uint) Constant {
        if c := self.consts[index]; c != nil {
            return c
        }
        panic(fmt.Sprintf("No constants at index %d", index))
    }*/
}
