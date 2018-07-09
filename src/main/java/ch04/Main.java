package ch04;

import ch04.classfile.ClassFile;
import ch04.classpath.ClassPath;
import ch04.rtda.Frame;
import ch04.rtda.LocalVars;
import ch04.rtda.OperandStack;
import org.joou.UInteger;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class Main
{

/*    func loadClass(className string, cp *classpath.Classpath) *classfile.ClassFile {
    classData, _, err := cp.ReadClass(className)
    if err != nil {
        panic(err)
    }

    cf, err := classfile.Parse(classData)
    if err != nil {
        panic(err)
    }

    return cf
  }*/
  public static ClassFile loadClass(String className, ClassPath cp){
      byte[] classData=cp.ReadClass(className);
      ClassFile classFile=new ClassFile();
      classFile.Parse(classData);
      return classFile;
  }

 /*   func printClassInfo(cf *classfile.ClassFile) {
        fmt.Printf("version: %v.%v\n", cf.MajorVersion(), cf.MinorVersion())
        fmt.Printf("constants count: %v\n", len(cf.ConstantPool()))
        fmt.Printf("access flags: 0x%x\n", cf.AccessFlags())
        fmt.Printf("this class: %v\n", cf.ClassName())
        fmt.Printf("super class: %v\n", cf.SuperClassName())
        fmt.Printf("interfaces: %v\n", cf.InterfaceNames())
        fmt.Printf("fields count: %v\n", len(cf.Fields()))
        for _, f := range cf.Fields() {
            fmt.Printf("  %s\n", f.Name())
        }
        fmt.Printf("methods count: %v\n", len(cf.Methods()))
        for _, m := range cf.Methods() {
            fmt.Printf("  %s\n", m.Name())
        }
    }*/
    public  static void printClassInfo(ClassFile cf){
        System.out.println("version:"+cf.getMajorVersion()+"."+cf.getMinorVersion());
        System.out.println("Constants count:"+cf.getConstantPool().constantPool.length);
        System.out.printf("access flags:0x%x\n",cf.getAccesFlags().intValue());
        System.out.printf("this class: %s\n",cf.className());
        System.out.printf("super class: %s\n",cf.superClassName());
        System.out.printf("interfaces: %s\n", Arrays.toString(cf.interfaceNames()));
        System.out.printf("fields count: %d\n",cf.getFields().length);
        for(int i=0;i<cf.getFields().length;i++){
            System.out.printf("%s\n",cf.getFields()[i].name());
        }
        System.out.printf("methods count: %d\n",cf.getMethods().length);
        for(int i=0;i<cf.getMethods().length;i++){
            System.out.printf("%s\n",cf.getMethods()[i].name());
        }
    }

/*    public static void startJVM(Cmd cmd){

        ClassPath cp= new ClassPath();
        cp=cp.parse(cmd.XjreOption,cmd.cpOpthion);
        System.out.print("classpath: "+cp.toString()+" classname: "+cmd.className+" args:");
        if(cmd.arg.size()>0){
        for(String str:cmd.arg){
            System.out.print(str+" ");
        }}
        System.out.println();
        String name=cmd.className.replace('.','/');
       *//* byte[] data=cp.ReadClass(name);
        for(byte b:data)
       System.out.print((0xFF & b)+" ");*//*
        ClassFile cf=loadClass(name,cp);
        printClassInfo(cf);
    }*/


/*    func startJVM(cmd *Cmd) {
        frame := rtda.NewFrame(100, 100)
        testLocalVars(frame.LocalVars())
        testOperandStack(frame.OperandStack())
    }*/

    public static void startJVM(Cmd cmd){
        Frame frame=Frame.newFrame(UInteger.valueOf(100),UInteger.valueOf(100));
        testLocalVars(frame.localVars);
        testOperandStack(frame.operandStack);
    }

/*    func testLocalVars(vars rtda.LocalVars) {
        vars.SetInt(0, 100)
        vars.SetInt(1, -100)
        vars.SetLong(2, 2997924580)
        vars.SetLong(4, -2997924580)
        vars.SetFloat(6, 3.1415926)
        vars.SetDouble(7, 2.71828182845)
        vars.SetRef(9, nil)
        println(vars.GetInt(0))
        println(vars.GetInt(1))
        println(vars.GetLong(2))
        println(vars.GetLong(4))
        println(vars.GetFloat(6))
        println(vars.GetDouble(7))
        println(vars.GetRef(9))
    }*/
     public static void testLocalVars(LocalVars vars){
         vars.setInt(UInteger.valueOf(0), 100);
         vars.setInt(UInteger.valueOf(1), -100);
         vars.setLong(UInteger.valueOf(2), 2997924580L);
         vars.setLong(UInteger.valueOf(4), -2997924580L);
         vars.setFloat(UInteger.valueOf(6), 3.1415926F);
         vars.setDouble(UInteger.valueOf(7), 2.71828182845);
         vars.setRef(UInteger.valueOf(9), null);
         System.out.println(vars.getInt(UInteger.valueOf(0)));
         System.out.println(vars.getInt(UInteger.valueOf(1)));
         System.out.println(vars.getLong(UInteger.valueOf(2)));
         System.out.println(vars.getLong(UInteger.valueOf(4)));
         System.out.println(vars.getFloat(UInteger.valueOf(6)));
         System.out.println(vars.getDouble(UInteger.valueOf(7)));
         System.out.println(vars.getRef(UInteger.valueOf(9)));
     }

/*
    func testOperandStack(ops *rtda.OperandStack) {
        ops.PushInt(100)
        ops.PushInt(-100)
        ops.PushLong(2997924580)
        ops.PushLong(-2997924580)
        ops.PushFloat(3.1415926)
        ops.PushDouble(2.71828182845)
        ops.PushRef(nil)
        println(ops.PopRef())
        println(ops.PopDouble())
        println(ops.PopFloat())
        println(ops.PopLong())
        println(ops.PopLong())
        println(ops.PopInt())
        println(ops.PopInt())
    }
*/
    public static void testOperandStack(OperandStack ops){
        ops.pushInt(100);
        ops.pushInt(-100);
        ops.pushLong(2997924580L);
        ops.pushLong(-2997924580L);
        ops.pushFloat(3.1415926F);
        ops.pushDouble(2.71828182845);
        ops.pushRef(null);
       System.out. println(ops.popRef());
       System.out. println(ops.popDouble());
       System.out. println(ops.popFloat());
       System.out. println(ops.popLong());
       System.out. println(ops.popLong());
       System.out. println(ops.popInt());
       System.out. println(ops.popInt());
    }
    public static void main( String[] args )throws Exception {
       // Entry entry=new Zip_Entry("F:\\zipTest\\rt.jar");
       // File file=new File("F:\\zipTest\\rt.jar");
        //entry.readClass("1.class");
       // System.out.println(file.getAbsolutePath());
        Cmd cmd=new Cmd();
        cmd.cmdParse(args);
       // if(cmd.className!=null){
           startJVM(cmd);
        //}
    }
}
