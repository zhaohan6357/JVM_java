package ch09.classfile;

import ch09.classfile.AttributeInfo;
import ch09.classfile.ClassReader;

public class DeprecatedAttribute extends AttributeInfo {
    @Override
    public void readInfo(ClassReader reader) {
//read nothing,marker attribute
    }
}
