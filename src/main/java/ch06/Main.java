package ch06;

import ch06.Cmd;
import ch06.classfile.ClassFile;
import ch06.classfile.MemberInfo;
import ch06.classpath.ClassPath;
import ch06.interpreter.interpreter;

/**
 * Hello world!
 */
public class Main {

    public static ClassFile loadClass(String className, ClassPath cp) {
        byte[] classData = cp.ReadClass(className);
        ClassFile classFile = new ClassFile();
        classFile.Parse(classData);
        return classFile;
    }


/*    func startJVM(cmd *Cmd) {
        cp := classpath.Parse(cmd.XjreOption, cmd.cpOption)
        className := strings.Replace(cmd.class, ".", "/", -1)
        cf := loadClass(className, cp)
        mainMethod := getMainMethod(cf)
        if mainMethod != nil {
            interpret(mainMethod)
        } else {
            fmt.Printf("Main method not found in class %s\n", cmd.class)
        }
    }*/

    /*    func getMainMethod(cf *classfile.ClassFile) *classfile.MemberInfo {
        for _, m := range cf.Methods() {
            if m.Name() == "main" && m.Descriptor() == "([Ljava/lang/String;)V" {
                return m
            }
        }r
        eturn nil
    }*/
    public static MemberInfo getMainMethod(ClassFile classFile) {
        for (MemberInfo m : classFile.getMethods()) {
            if (m.name().equals("main") && m.descripter().equals("([Ljava/lang/String;)V")) {
                return m;
            }
        }
        return null;
    }

    public static void startJVM(Cmd cmd) {
        ClassPath cp = new ClassPath();
        cp = cp.parse(cmd.XjreOption, cmd.cpOpthion);
        System.out.print("classpath: " + cp.toString() + " classname: " + cmd.className + " args:");
        if (cmd.arg.size() > 0) {
            for (String str : cmd.arg) {
                System.out.print(str + " ");
            }
        }
        System.out.println();
        String name = cmd.className.replace('.', '/');
        ClassFile cf = loadClass(name, cp);
        MemberInfo m = getMainMethod(cf);
        if (m != null) {
            interpreter.interpret(m);
        } else {
            System.out.println("Main method not found in class");
        }
    }


    public static void main(String[] args) throws Exception {
        Cmd cmd = new Cmd();
        cmd.cmdParse(args);
        startJVM(cmd);
    }
}
