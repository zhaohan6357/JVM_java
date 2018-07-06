package ch02;

import ch02.classpath.ClassPath;
import ch02.classpath.DirEntry;
import ch02.classpath.Entry;
import ch02.classpath.Zip_Entry;

import java.io.File;
import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class Main
{

    public static void startJVM(Cmd cmd){
        ClassPath cp= new ClassPath();
        cp=cp.parse(cmd.XjreOption,cmd.cpOpthion);
        System.out.print("classpath: "+cp.toString()+" classname: "+cmd.className+" args:");
        if(cmd.arg.size()>0){
        for(String str:cmd.arg){
            System.out.print(str+" ");
        }}
        System.out.println();
       // String className=cmd.className.replace('.','\\');
        //File file=new File(className);
        //String name=file.getName();
        String name=cmd.className.replace('.','/');
        byte[] data=cp.ReadClass(name);
        for(byte b:data)
        System.out.print((0xFF & b)+" ");
    }
    public static void main( String[] args )throws Exception {
       // Entry entry=new Zip_Entry("F:\\zipTest\\rt.jar");
       // File file=new File("F:\\zipTest\\rt.jar");
        //entry.readClass("1.class");
       // System.out.println(file.getAbsolutePath());
        Cmd cmd=new Cmd();
        cmd.cmdParse(args);
        if(cmd.className!=null){
           startJVM(cmd);
        }
    }
}
