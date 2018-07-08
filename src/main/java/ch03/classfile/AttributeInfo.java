package ch03.classfile;

import org.joou.UInteger;
import org.joou.UShort;

//TODO
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

    public static AttributeInfo newAttributeInfo(String attrName, UInteger attrLen, ConstantPool cp){
/*        func newAttributeInfo(attrName string, attrLen uint32,
                cp ConstantPool) AttributeInfo {
            switch attrName {
                case "Code": return &CodeAttribute{cp: cp}
                case "ConstantValue": return &ConstantValueAttribute{}
                case "Deprecated": return &DeprecatedAttribute{}
                case "Exceptions": return &ExceptionsAttribute{}
                case "LineNumberTable": return &LineNumberTableAttribute{}
                case "LocalVariableTable": return &LocalVariableTableAttribute{}
                case "SourceFile": return &SourceFileAttribute{cp: cp}
                case "Synthetic": return &SyntheticAttribute{}
                default: return &UnparsedAttribute{attrName, attrLen, nil}
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
