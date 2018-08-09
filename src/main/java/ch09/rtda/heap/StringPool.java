package ch09.rtda.heap;

import ch09.rtda.heap.ClassLoader;
import ch09.rtda.heap.Object;

import java.util.HashMap;

public class StringPool {
    public static HashMap<String, ch09.rtda.heap.Object> internedString = new HashMap<>();

    public static ch09.rtda.heap.Object JString(ClassLoader loader, String str) {
        if (internedString.containsKey(str)) {
            return internedString.get(str);
        }
        char[] chars=str.toCharArray();
        ch09.rtda.heap.Object jChars=new ch09.rtda.heap.Object(loader.loadClass("[C"),chars);

        ch09.rtda.heap.Object jStr=loader.loadClass("java/lang/String").newObject();
        jStr.setRefVar("value","[C",jChars);

        internedString.put(str,jStr);
        return jStr;
    }

    public static String getString(Object jStr){
        char[] charArr=jStr.getRefVar("value","[C").Chars();
        return String.valueOf(charArr);
    }

}