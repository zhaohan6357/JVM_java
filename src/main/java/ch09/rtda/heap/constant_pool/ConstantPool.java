package ch09.rtda.heap.constant_pool;

import ch09.classfile.*;
import ch09.rtda.heap.*;
import ch09.rtda.heap.Class;
import org.joou.UInteger;

import java.lang.Object;

public class ConstantPool {
    public Class clazz;
    public ch09.rtda.heap.constant_pool.Constant[] consts;

    public static ConstantPool newConstantPool(Class clazz, ch09.classfile.ConstantPool cfCp) {
        int cpCount = cfCp.constantPool.length;
        ch09.rtda.heap.constant_pool.Constant[] consts = new ch09.rtda.heap.constant_pool.Constant[cpCount];
        ConstantPool constantPool = new ConstantPool();
        constantPool.clazz = clazz;
        constantPool.consts = consts;
        for (int i = 1; i < cpCount; i++) {
            ConstantInfo cpInfo = cfCp.constantPool[i];
            consts[i]=new ch09.rtda.heap.constant_pool.Constant();
            if (cpInfo.getClass() == ConstantIntegerInfo.class) {
                ConstantIntegerInfo integerInfo = (ConstantIntegerInfo) cpInfo;
                consts[i].object=integerInfo.val;
            } else if (cpInfo.getClass() == ConstantFloatInfo.class) {
                ConstantFloatInfo constantFloatInfo = (ConstantFloatInfo) cpInfo;
                consts[i].object=constantFloatInfo.val;
            } else if (cpInfo.getClass() == ConstantLongInfo.class) {
                ConstantLongInfo constantLongInfo = (ConstantLongInfo) cpInfo;
                consts[i].object=constantLongInfo.val;
                i++;
            } else if (cpInfo.getClass() == ConstantDoubleInfo.class) {
                ConstantDoubleInfo constantDoubleInfo=(ConstantDoubleInfo)cpInfo;
                consts[i].object=constantDoubleInfo.val;
                i++;
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
    public ch09.rtda.heap.constant_pool.Constant getConstant(UInteger index){
        if(consts[index.intValue()]!=null){
            return consts[index.intValue()];
        }
        System.out.println("no constant");
        return null;
    }
    /*
    func (self *ConstantPool) GetConstant(index uint) Constant {
        if c := self.consts[index]; c != nil {
            return c
        }
        panic(fmt.Sprintf("No constants at index %d", index))
    }*/
}
