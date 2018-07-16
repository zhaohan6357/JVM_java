package ch08.rtda.heap;

import java.util.HashMap;

public class StringPool {
    public static HashMap<String, Object> internedString = new HashMap<>();

    public static Object JString(ClassLoader loader, String str) {
        if (internedString.containsKey(str)) {
            return internedString.get(str);
        }
        char[] chars=str.toCharArray();
        Object jChars=new Object(loader.loadClass("[C"),chars);

        Object jStr=loader.loadClass("java/lang/String").newObject();
        jStr.setRefVar("value","[C",jChars);

        internedString.put(str,jStr);
        return jStr;
    }

    public static String getString(Object jStr){
        char[] charArr=jStr.getRefVar("value","[C").Chars();
        return String.valueOf(charArr);
    }

}