package ch08.rtda.heap;

import ch08.rtda.heap.Class;
import ch08.rtda.heap.Method;

public class Method_Lookup {
    public static ch08.rtda.heap.Method LookupMethodInClass(ch08.rtda.heap.Class clazz, String name, String descriptor){
        for(ch08.rtda.heap.Class c = clazz; c!=null; c=c.superClass){
            for(ch08.rtda.heap.Method method:c.methods){
                if(method.name.equals(name)&&method.descriptor.equals(descriptor)){
                    return method;
                }
            }
        }
        return null;
    }

    public static ch08.rtda.heap.Method lookupMethodInInterfaces(ch08.rtda.heap.Class[] ifaces, String name, String descriptor){
        for(Class iface:ifaces){
            for(ch08.rtda.heap.Method method:iface.methods){
                if(method.name.equals(name)&&method.descriptor.equals(descriptor)){
                    return method;
                }
            }
            Method method=lookupMethodInInterfaces(iface.interfaces,name,descriptor);
            if(method!=null){
                return method;
            }
        }
        return null;
    }
}
