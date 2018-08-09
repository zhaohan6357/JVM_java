package ch09.rtda.heap;

import ch09.classfile.ClassFile;
import ch09.classpath.ClassPath;
import ch09.rtda.heap.Access_flags;
import ch09.rtda.heap.Class;
import ch09.rtda.heap.Field;
import ch09.rtda.heap.Object;
import ch09.rtda.heap.Slots;
import ch09.rtda.heap.StringPool;
import ch09.rtda.heap.constant_pool.ConstantPool;
import org.joou.UInteger;
import org.joou.UShort;;
import java.util.HashMap;
import java.util.Map;

public class ClassLoader {

    public ClassPath cp;
    public HashMap<String, ch09.rtda.heap.Class> classMap;
    boolean verboseFlag;

    public static ClassLoader newClassLoader(ClassPath cp,boolean verboseFlag) {
        ClassLoader classLoader = new ClassLoader();
        classLoader.cp = cp;
        classLoader.verboseFlag=verboseFlag;
        classLoader.classMap = new HashMap<>();
        classLoader.loadBasicClasses();
        classLoader.loadPrimitiveClasses();
        return classLoader;
    }

    private void loadPrimitiveClasses() {
        for(Map.Entry<String,String> entry:CLASSNAME_HELPER.primitiveTypes.entrySet()){
            this.loadPrimitiveClass(entry.getKey());
        }

    }

    private void loadPrimitiveClass(String className) {
        Class clazz=new Class();
        clazz.accessFlags=UShort.valueOf(Access_flags.ACC_PUBLIC);
        clazz.name=className;
        clazz.loader=this;
        clazz.initStarted=true;
        clazz.jClass=this.classMap.get("java/lang/Class").newObject();
        clazz.jClass.extra=clazz;
        this.classMap.put(className,clazz);
    }

    private void loadBasicClasses() {
        Class jlClassClass=this.loadClass("java/lang/Class");
        for(Map.Entry<String,Class> entry:classMap.entrySet()){
            if(entry.getValue().jClass==null){
                entry.getValue().jClass=jlClassClass.newObject();
                entry.getValue().jClass.extra=entry.getValue();
            }
        }
    }

    public ch09.rtda.heap.Class loadClass(String name) {
        if (classMap.containsKey(name)) {
            return classMap.get(name);
        }
        Class clazz;
        if(name.charAt(0)=='['){
            clazz = loadArrayClass(name);
        }else{

            clazz = loadNonArrayClass(name);
        }
        if(classMap.containsKey("java/lang/Class")){
            clazz.jClass=classMap.get("java/lang/Class").newObject();
            clazz.jClass.extra=clazz;
        }
        return clazz;
    }

    public ch09.rtda.heap.Class loadArrayClass(String name2){
        ch09.rtda.heap.Class clazz=new ch09.rtda.heap.Class();
        clazz.accessFlags= UShort.valueOf(Access_flags.ACC_PUBLIC);
        clazz.name=name2;
        clazz.loader=this;
        clazz.initStarted=true;
        clazz.superClass=this.loadClass("java/lang/Object");
        ch09.rtda.heap.Class[] interfaces=new ch09.rtda.heap.Class[2];
        interfaces[0]=this.loadClass("java/lang/Cloneable");
        interfaces[1]=this.loadClass("java/io/Serializable");
        clazz.interfaces=interfaces;
        this.classMap.put(name2,clazz);
        return clazz;
    }


    public ch09.rtda.heap.Class loadNonArrayClass(String name) {
        byte[] data = readClass(name);
        ch09.rtda.heap.Class clazz = defineClass(data);
        link(clazz);
        if(this.verboseFlag){
            System.out.printf("[Loaded %s \n",name);
        }
        return clazz;
    }

    private void link(ch09.rtda.heap.Class clazz) {
        verify(clazz);
        prepare(clazz);
    }


    /*func prepare(class *Class) {
        calcInstanceFieldSlotIds(class)
        calcStaticFieldSlotIds(class)
        allocAndInitStaticVars(class)
    }*/
    public void prepare(ch09.rtda.heap.Class clazz) {
        calcInstanceFieldSlotIds(clazz);
        calcStaticFieldSlotIds(clazz);
        allocAndInitStaticVars(clazz);
    }

    /* func allocAndInitStaticVars(class *Class) {
         class.staticVars = newSlots(class.staticSlotCount)
         for _, field := range class.fields {
             if field.IsStatic() && field.IsFinal() {
                 initStaticFinalVar(class, field)
             }
         }
     }*/
    private void allocAndInitStaticVars(ch09.rtda.heap.Class clazz) {
        clazz.staticVars = ch09.rtda.heap.Slots.newSlots(clazz.staticSlotCount);
        for (ch09.rtda.heap.Field field : clazz.fields) {
            if (field.IsStatic() && field.IsFinal()) {
                initStaticFinalVar(clazz, field);
            }
        }

    }
   /* func initStaticFinalVar(class *Class, field *Field) {
        vars := class.staticVars
        cp := class.constantPool
        cpIndex := field.ConstValueIndex()
        slotId := field.SlotId()

        if cpIndex > 0 {
            switch field.Descriptor() {
                case "Z", "B", "C", "S", "I":
                    val := cp.GetConstant(cpIndex).(int32)
                        vars.SetInt(slotId, val)
                case "J":
                    val := cp.GetConstant(cpIndex).(int64)
                        vars.SetLong(slotId, val)
                case "F":
                    val := cp.GetConstant(cpIndex).(float32)
                        vars.SetFloat(slotId, val)
                case "D":
                    val := cp.GetConstant(cpIndex).(float64)
                        vars.SetDouble(slotId, val)
                case "Ljava/lang/String;":
                    panic("todo")
            }
        }
    }*/
    private void initStaticFinalVar(ch09.rtda.heap.Class clazz, ch09.rtda.heap.Field field) {
        Slots vars=clazz.staticVars;
        ConstantPool cp=clazz.constantPool;
        UInteger cpIndex=field.constValueIndex;
        UInteger slotId=field.slotId;
        if(cpIndex!=null&&cpIndex.intValue()>0){
            switch (field.descriptor){
                case "Z":
                case "B":
                case "C":
                case "S":
                case "I":
                    int val=(int)(cp.getConstant(cpIndex).object);
                    vars.setInt(slotId,val);
                    return;
                case  "J":
                    long lval=(long)(cp.getConstant(cpIndex).object);
                    vars.setLong(slotId,lval);
                    return;
                case  "F":
                    float fval=(float)(cp.getConstant(cpIndex).object);
                    vars.setFloat(slotId,fval);
                    return;
                case  "D":
                    double dval=(double) (cp.getConstant(cpIndex).object);
                    vars.setDouble(slotId,dval);
                    return;
                case  "Ljava/lang/String;":
                    String str=(String)(cp.getConstant(cpIndex).object);
                    Object jStr= StringPool.JString(clazz.loader,str);
                    vars.setRef(slotId,jStr);
                    return ;

            }
        }


    }
   /* func calcStaticFieldSlotIds(class *Class) {
        slotId := uint(0)
        for _, field := range class.fields {
            if field.IsStatic() {
                field.slotId = slotId
                slotId++
                if field.isLongOrDouble() {
                    slotId++
                }
            }
        }
        class.staticSlotCount = slotId
    }*/

    private void calcStaticFieldSlotIds(ch09.rtda.heap.Class clazz) {
        UInteger slotId = UInteger.valueOf(0);
        for (int i = 0; i < clazz.fields.length; i++) {
            ch09.rtda.heap.Field field = clazz.fields[i];
            if (field.IsStatic()) {
                field.slotId = slotId;
                slotId = slotId.add(1);
                if (field.isLongOrDouble()) {
                    slotId = slotId.add(1);
                }
            }
        }
        clazz.staticSlotCount = slotId;
    }

    /* func calcInstanceFieldSlotIds(class *Class) {
         slotId := uint(0)
         if class.superClass != nil {
             slotId = class.superClass.instanceSlotCount
         }
         for _, field := range class.fields {
             if !field.IsStatic() {
                 field.slotId = slotId
                 slotId++
                 if field.isLongOrDouble() {
                     slotId++
                 }
             }
         }
         class.instanceSlotCount = slotId
     }*/
    private void calcInstanceFieldSlotIds(ch09.rtda.heap.Class clazz) {
        UInteger slotId = UInteger.valueOf(0);
        if (clazz.superClass != null) {
            slotId = clazz.superClass.instanceSlotCount;
        }
        for (int i = 0; i < clazz.fields.length; i++) {
            Field field = clazz.fields[i];
            if (!field.IsStatic()) {
                field.slotId = slotId;
                slotId = slotId.add(1);
                if (field.isLongOrDouble()) {
                    slotId = slotId.add(1);
                }
            }
        }
        clazz.instanceSlotCount = slotId;
    }

    private void verify(ch09.rtda.heap.Class clazz) {
        //todo  not  do
    }

    /*func (self *ClassLoader) defineClass(data []byte) *Class {
        class := parseClass(data)
        class.loader = self
        resolveSuperClass(class)
        resolveInterfaces(class)
        self.classMap[class.name] = class
        return class
    }*/
    public ch09.rtda.heap.Class defineClass(byte[] data) {
        ch09.rtda.heap.Class clazz = parseClass(data);
        clazz.loader = this;
        resolveSuperClass(clazz);
        resolveInterfaces(clazz);
        classMap.put(clazz.name, clazz);
        return clazz;

    }

    /*
        func parseClass(data []byte) *Class {
            cf, err := classfile.Parse(data)
            if err != nil {
                //panic("java.lang.ClassFormatError")
                panic(err)
            }
            return newClass(cf)
        }
    */
    private ch09.rtda.heap.Class parseClass(byte[] data) {
        ClassFile cf = new ClassFile();
        cf = cf.Parse(data);
        return ch09.rtda.heap.Class.newClass(cf);
    }

    /*func resolveSuperClass(class *Class) {
        if class.name != "java/lang/Object" {
            class.superClass = class.loader.LoadClass(class.superClassName)
        }
    }*/

    private void resolveSuperClass(ch09.rtda.heap.Class clazz) {
        if (!clazz.name.equals("java/lang/Object")) {
            clazz.superClass = clazz.loader.loadClass(clazz.superClassName);
        }
    }

   /* func resolveInterfaces(class *Class) {
        interfaceCount := len(class.interfaceNames)
        if interfaceCount > 0 {
            class.interfaces = make([]*Class, interfaceCount)
            for i, interfaceName := range class.interfaceNames {
                class.interfaces[i] = class.loader.LoadClass(interfaceName)
            }
        }
    }*/


    private void resolveInterfaces(ch09.rtda.heap.Class clazz) {
        int interfaceCount = clazz.interfaceNames.length;
        if (interfaceCount > 0) {
            clazz.interfaces = new Class[interfaceCount];
            for (int i = 0; i < interfaceCount; i++) {
                clazz.interfaces[i] = clazz.loader.loadClass(clazz.interfaceNames[i]);
            }
        }
    }


    /*func (self *ClassLoader) readClass(name string) ([]byte, classpath.Entry) {
        data, entry, err := self.cp.ReadClass(name)
        if err != nil {
            panic("java.lang.ClassNotFoundException: " + name)
        }
        return data, entry
    }*/
    public byte[] readClass(String name) {
        byte[] data = cp.ReadClass(name);
        if (data.length == 0) {
            System.out.println("java.lang.ClassNotFoundException: " + name);
        }
        return data;
    }

}
