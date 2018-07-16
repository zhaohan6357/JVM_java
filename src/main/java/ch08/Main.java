package ch08;

import ch08.classpath.ClassPath;
import ch08.interpreter.interpreter;
import ch08.rtda.heap.Class;
import ch08.rtda.heap.ClassLoader;
import ch08.rtda.heap.Method;

/**
 * Hello world!
 */
public class Main {

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
        ClassLoader classLoader=ClassLoader.newClassLoader(cp,cmd.verboseClassFlag);
        String className = cmd.className.replace('.', '/');
        Class mainClass=classLoader.loadClass(className);
        Method mainMethod=mainClass.getMainMethod();
        if (mainMethod!= null) {
            interpreter.interpret(mainMethod,cmd.verboseInstFlag,cmd.args);
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
