package ch08.rtda.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MethodDescriptor {
    ArrayList<String> parameterTypes=new ArrayList<>();
    String returnType;

    public void addParameterType(String t) {

        parameterTypes.add(t);
    }
}
