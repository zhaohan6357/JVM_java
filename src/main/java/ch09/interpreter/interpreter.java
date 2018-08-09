package ch09.interpreter;

import ch09.classfile.CodeAttribute;
import ch09.classfile.ExceptionTableEntry;
import ch09.classfile.MemberInfo;
import ch09.instructions.base.ByteCodeReader;
import ch09.instructions.base.instruction.BranchInstruction;
import ch09.instructions.base.instruction.Instruction;
import ch09.instructions.factory.Factory;
import ch09.rtda.Frame;
import ch09.rtda.Thread;
import ch09.rtda.heap.*;
import ch09.rtda.heap.Class;
import ch09.rtda.heap.ClassLoader;
import ch09.rtda.heap.Object;
import com.sun.org.apache.xpath.internal.SourceTree;
import org.joou.UByte;
import org.joou.UInteger;
import org.joou.UShort;

import java.util.Arrays;

public class interpreter {

    public static void interpret(Method method,boolean logInst,String[] args) {
        Thread thread=Thread.newThread();
        Frame frame=thread.newFrame(method);
        thread.pushFrame(frame);
        //try {
        Object jArgs=createArgsArray(method.clazz.loader,args);
        frame.localVars.setRef(UInteger.valueOf(0),jArgs);
        loop(thread, method.code,logInst);
        /*}catch (Exception e){
            catchErr(thread);
        }*/
    }

    public static Object createArgsArray(ClassLoader loader,String[] args){
        Class stringClass=loader.loadClass("java/lang/String");
       // if(args!=null){
        Object argsArr=stringClass.arrayClass().newArray(UInteger.valueOf(args.length));
        Object[] jArgs=argsArr.Refs();
        for(int i=0;i<args.length;i++){
            jArgs[i]= StringPool.JString(loader,args[i]);
        }
        return argsArr;
    //}
      //  return null;
    }
    public static  void catchErr(Thread thread){
        logFrames(thread);
    }
    public static void logFrames(Thread thread){
        while(!thread.isStackEmpty()){
            Frame frame=thread.popFrame();
            Method method=frame.method;
            String className=method.clazz.name;
            System.out.printf(">>pc:%4d %s.%s%s\n",
                    frame.nextPC,className,method.name,method.descriptor);
        }
    }

    public static void loop(Thread thread,byte[] code,boolean logInst){
        ByteCodeReader reader=new ByteCodeReader();
       Frame frame;
        int pc;
        UByte opcode;
        Instruction inst;
        for(;;){
            frame=thread.currentFrame();
            pc=frame.nextPC;
            thread.setPc(pc);

            reader.reset(frame.method.code,pc);
            opcode=reader.readUint8();
            inst= Factory.newInstruction(opcode);
            inst.FetchOperands(reader);
            frame.setNextPC(reader.pc);

            if(logInst){
                logInstruction(frame,inst);
            }

          //  System_.out.printf("pc:%2d,  instruction:%s oprand:%s\n",pc,inst.getClass(),inst.index);
            inst.Execute(frame);
            if(thread.isStackEmpty()){
                break;
            }
        }

    }

    private static void logInstruction(Frame frame, Instruction inst) {
       Method method=frame.method;
       String className=method.clazz.name;
       String methodName=method.name;
       int pc=frame.thread.pc;


       System.out.printf("%s.%s() %d %s %s\n",className,methodName,pc,inst.getClass(),inst.index);
    }

}
