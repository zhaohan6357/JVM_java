package ch07.rtda.heap;

import ch07.classfile.ClassFile;
import ch07.classpath.ClassPath;
import ch07.rtda.Slot;
import ch07.rtda.heap.Class;
import ch07.rtda.heap.Field;
import ch07.rtda.heap.Slots;
import ch07.rtda.heap.constant_pool.ConstantPool;
import org.joou.UInteger;

import java.util.HashMap;

public class ClassLoader {
    /* type ClassLoader struct {
         cp       *classpath.Classpath
         classMap map[string]*Class // loaded classes
     }

     func NewClassLoader(cp *classpath.Classpath) *ClassLoader {
         return &ClassLoader{
             cp:       cp,
                     classMap: make(map[string]*Class),
         }
     }*/
    ClassPath cp;
    HashMap<String, ch07.rtda.heap.Class> classMap;
    boolean verboseFlag;

    public static ClassLoader newClassLoader(ClassPath cp,boolean verboseFlag) {
        ClassLoader classLoader = new ClassLoader();
        classLoader.cp = cp;
        classLoader.verboseFlag=verboseFlag;
        classLoader.classMap = new HashMap<>();
        return classLoader;
    }

    /*func (self *ClassLoader) LoadClass(name string) *Class {
        if class, ok := self.classMap[name]; ok {
            // already loaded
            return class
        }

        return self.loadNonArrayClass(name)
    }*/
    public ch07.rtda.heap.Class loadClass(String name) {
        if (classMap.containsKey(name)) {
            return classMap.get(name);
        }
        return loadNonArrayClass(name);
    }

    /*
        func (self *ClassLoader) loadNonArrayClass(name string) *Class {
            data, entry := self.readClass(name)
            class := self.defineClass(data)
            link(class)
            fmt.Printf("[Loaded %s from %s]\n", name, entry)
            return class
        }*/
    public ch07.rtda.heap.Class loadNonArrayClass(String name) {
        byte[] data = readClass(name);
        ch07.rtda.heap.Class clazz = defineClass(data);
        link(clazz);
        if(this.verboseFlag){
            System.out.printf("[Loaded %s \n",name);
        }
        return clazz;
    }

    private void link(ch07.rtda.heap.Class clazz) {
        verify(clazz);
        prepare(clazz);
    }


    /*func prepare(class *Class) {
        calcInstanceFieldSlotIds(class)
        calcStaticFieldSlotIds(class)
        allocAndInitStaticVars(class)
    }*/
    public void prepare(ch07.rtda.heap.Class clazz) {
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
    private void allocAndInitStaticVars(ch07.rtda.heap.Class clazz) {
        clazz.staticVars = ch07.rtda.heap.Slots.newSlots(clazz.staticSlotCount);
        for (ch07.rtda.heap.Field field : clazz.fields) {
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
    private void initStaticFinalVar(ch07.rtda.heap.Class clazz, ch07.rtda.heap.Field field) {
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
                    System.out.println("todo");
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

    private void calcStaticFieldSlotIds(ch07.rtda.heap.Class clazz) {
        UInteger slotId = UInteger.valueOf(0);
        for (int i = 0; i < clazz.fields.length; i++) {
            ch07.rtda.heap.Field field = clazz.fields[i];
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
    private void calcInstanceFieldSlotIds(ch07.rtda.heap.Class clazz) {
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

    private void verify(ch07.rtda.heap.Class clazz) {
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
    public ch07.rtda.heap.Class defineClass(byte[] data) {
        ch07.rtda.heap.Class clazz = parseClass(data);
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
    private ch07.rtda.heap.Class parseClass(byte[] data) {
        ClassFile cf = new ClassFile();
        cf = cf.Parse(data);
        return ch07.rtda.heap.Class.newClass(cf);
    }

    /*func resolveSuperClass(class *Class) {
        if class.name != "java/lang/Object" {
            class.superClass = class.loader.LoadClass(class.superClassName)
        }
    }*/

    private void resolveSuperClass(ch07.rtda.heap.Class clazz) {
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


    private void resolveInterfaces(ch07.rtda.heap.Class clazz) {
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
