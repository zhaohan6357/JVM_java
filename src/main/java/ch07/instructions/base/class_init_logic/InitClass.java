package ch07.instructions.base.class_init_logic;

import ch07.rtda.Frame;
import ch07.rtda.Thread;
import ch07.rtda.heap.Class;
import ch07.rtda.heap.Method;

public class InitClass {
    public static void InitClass(Thread thread, Class clazz){
        clazz.startInit();
        scheduleClinit(thread,clazz);
        initSuperClass(thread,clazz);
    }
    private static void scheduleClinit(Thread thread, Class clazz) {
        Method clinit=clazz.getClinitMethod();
        if(clinit!=null){
            Frame newFrame=thread.newFrame(clinit);
            thread.pushFrame(newFrame);
        }
    }
    private static void initSuperClass(Thread thread, Class clazz) {
        if(!clazz.IsInterface()){
            Class superClazz=clazz.superClass;
            if(superClazz!=null&&!superClazz.initStarted){
                InitClass(thread,superClazz);
    }
}

    }


}
