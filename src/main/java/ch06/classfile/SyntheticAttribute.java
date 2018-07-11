package ch06.classfile;

import ch06.classfile.AttributeInfo;
import ch06.classfile.ClassReader;

public class SyntheticAttribute extends AttributeInfo {

    @Override
    public void readInfo(ClassReader reader) {
        //read nothing,marker attribute
    }
}
