package ch07.classfile;

import ch07.classfile.AttributeInfo;
import ch07.classfile.ClassReader;

public class DeprecatedAttribute extends AttributeInfo {
    @Override
    public void readInfo(ClassReader reader) {
//read nothing,marker attribute
    }
}
