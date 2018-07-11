package ch06.classfile;

import ch06.classfile.ClassReader;
import ch06.classfile.CodeAttribute;
import ch06.classfile.ConstantPool;
import ch06.classfile.ConstantValueAttribute;
import ch06.classfile.DeprecatedAttribute;
import ch06.classfile.ExceptionsAttribute;
import ch06.classfile.LineNumberTableAttribute;
import ch06.classfile.LocalVariableTableAttribute;
import ch06.classfile.SourceFileAttribute;
import ch06.classfile.SyntheticAttribute;
import ch06.classfile.UnparsedAttribute;
import org.joou.UInteger;


public class AttributeInfo {

    /*type AttributeInfo interface {
        readInfo(reader *ClassReader)
    }
    func readAttributes(reader *ClassReader, cp ConstantPool) []AttributeInfo {...}
    func readAttribute(reader *ClassReader, cp ConstantPool) AttributeInfo {...}
    func newAttributeInfo(attrName string, attrLen uint32,
                          cp ConstantPool) AttributeInfo {...}*/
    public void readInfo(ClassReader reader){

    }



    public static ch06.classfile.AttributeInfo newAttributeInfo(String attrName, UInteger attrLen, ConstantPool cp){
/*        func newAttributeInfo(attrName string, attrLen uint32,
                cp ConstantPool) AttributeInfo {
            switch attrName {
                case "Code": return new CodeAttribute{cp: cp}
                case "ConstantValue": return new ConstantValueAttribute();
                case "Deprecated": return new DeprecatedAttribute();
                case "Exceptions": return new ExceptionsAttribute();
                case "LineNumberTable": return new LineNumberTableAttribute();
                case "LocalVariableTable": return new LocalVariableTableAttribute();
                case "SourceFile": return new SourceFileAttribute{cp: cp}
                case "Synthetic": return new SyntheticAttribute();
                default: return new UnparsedAttribute{attrName, attrLen, nil}
            }
           }*/
        switch (attrName){
            case "Code": return new CodeAttribute(cp);
            case "ConstantValue": return new ConstantValueAttribute();
            case "Deprecated": return new DeprecatedAttribute();
            case "Exceptions": return new ExceptionsAttribute();
            case "LineNumberTable": return new LineNumberTableAttribute();
            case "LocalVariableTable": return new LocalVariableTableAttribute();
            case "SourceFile": return new SourceFileAttribute(cp);
            case "Synthetic": return new SyntheticAttribute();
            default: return new UnparsedAttribute(attrName, attrLen,null);

        }
    }
}
