package ch08.classfile;

import ch08.classfile.AttributeInfo;
import ch08.classfile.ClassReader;

public class DeprecatedAttribute extends AttributeInfo {
    @Override
    public void readInfo(ClassReader reader) {
//read nothing,marker attribute
    }
}
