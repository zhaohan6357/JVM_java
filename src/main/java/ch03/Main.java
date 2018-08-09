package ch03;

import ch03.classfile.ClassFile;
import ch03.classfile.ClassReader;
import ch03.classpath.ClassPath;
import sun.java2d.SurfaceDataProxy;

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
  public static ClassFile loadClass(String className,ClassPath cp){
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

    public static void startJVM(Cmd cmd){

        ClassPath cp= new ClassPath();
        cp=cp.parse(cmd.XjreOption,cmd.cpOpthion);
        System.out.print("classpath: "+cp.toString()+" classname: "+cmd.className+" args:");
        if(cmd.arg.size()>0){
        for(String str:cmd.arg){
            System.out.print(str+" ");
        }}
        System.out.println();
        String name=cmd.className.replace('.','/');
       /* byte[] data=cp.ReadClass(name);
        for(byte b:data)
       System_.out.print((0xFF new  b)+" ");*/
        ClassFile cf=loadClass(name,cp);
        printClassInfo(cf);


    }
    public static void main( String[] args )throws Exception {
       // Entry entry=new Zip_Entry("F:\\zipTest\\rt.jar");
       // File file=new File("F:\\zipTest\\rt.jar");
        //entry.readClass("1.class");
       // System_.out.println(file.getAbsolutePath());
        Cmd cmd=new Cmd();
        cmd.cmdParse(args);
        if(cmd.className!=null){
           startJVM(cmd);
        }
    }
}
