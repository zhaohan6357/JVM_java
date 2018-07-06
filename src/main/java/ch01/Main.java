package ch01;

/**
 * Hello world!
 *
 */
public class Main
{
    public static void startJVM(Cmd cmd){
        System.out.print("classpath: "+cmd.cpOpthion+" classname: "+cmd.className+" args:");
        for(String str:cmd.arg){
            System.out.print(str+" ");
        }
    }
    public static void main( String[] args ) {
        Cmd cmd=new Cmd();
        cmd.cmdParse(args);
        if(cmd.className!=null){
           startJVM(cmd);
        }
    }
}
