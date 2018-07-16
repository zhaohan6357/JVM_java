package ch08.rtda.heap;

import sun.misc.ClassLoaderUtil;

import java.util.HashMap;
import java.util.Map;

public class CLASSNAME_HELPER {
    public static HashMap<String, String> primitiveTypes;

    static {
        primitiveTypes = new HashMap<>();
        primitiveTypes.put("void", "V");
        primitiveTypes.put("boolean", "Z");
        primitiveTypes.put("byte", "B");
        primitiveTypes.put("short", "S");
        primitiveTypes.put("int", "I");
        primitiveTypes.put("long", "J");
        primitiveTypes.put("char", "C");
    }
    public static  String toDescriptor(String className){
        if(className.charAt(0)=='['){
            return className;
        }
        if(primitiveTypes.containsKey(className)){
            return primitiveTypes.get(className);
        }
        return "L"+className+";";
    }

    public static String getArrayClassName(String className){
        return "["+toDescriptor(className);
    }

    public static String getComponentClassName(String className){
        if(className.charAt(0)=='['){
            String componentTypeDescriptor=className.substring(1);
            return toClassName(componentTypeDescriptor);
        }
        System.out.println("Not array"+className);
        return null;
    }
    public static String toClassName(String descriptor){
        if(descriptor.charAt(0)=='['){
            return descriptor;
        }
        if(descriptor.charAt(0)=='L'){

            return descriptor.substring(1,descriptor.length()-1);
        }

        for(Map.Entry<String,String> entry:primitiveTypes.entrySet()){
            if(entry.getValue().equals(descriptor)){
                return entry.getKey();
            }
        }
        System.out.println("Invalid descriptor: "+descriptor);
        return null;
    }

}
