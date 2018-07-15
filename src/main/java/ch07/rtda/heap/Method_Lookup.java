package ch07.rtda.heap;

public class Method_Lookup {
    public static Method LookupMethodInClass(Class clazz,String name,String descriptor){
        for(Class c=clazz;c!=null;c=c.superClass){
            for(Method method:c.methods){
                if(method.name.equals(name)&&method.descriptor.equals(descriptor)){
                    return method;
                }
            }
        }
        return null;
    }

    public static Method lookupMethodInInterfaces(Class[] ifaces,String name,String descriptor){
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
