package ch09.rtda.heap;

import ch09.rtda.heap.Class;
import ch09.rtda.heap.Method;

public class Method_Lookup {
    public static Method LookupMethodInClass(Class clazz, String name, String descriptor){
        for(Class c = clazz; c!=null; c=c.superClass){
           // if(c.methods!=null){//todo 这里不判断会出错,如果Class类内未初始化
            for(Method method:c.methods){
                if(method.name.equals(name)&&method.descriptor.equals(descriptor)){
                    return method;
                }
            }}
        //}
        return null;
    }

    public static Method lookupMethodInInterfaces(Class[] ifaces, String name, String descriptor){
        for(Class iface:ifaces){
            for(Method method:iface.methods){
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
