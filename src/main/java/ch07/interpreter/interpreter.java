package ch07.interpreter;

import ch07.classfile.CodeAttribute;
import ch07.classfile.ExceptionTableEntry;
import ch07.classfile.MemberInfo;
import ch07.instructions.base.ByteCodeReader;
import ch07.instructions.base.instruction.BranchInstruction;
import ch07.instructions.base.instruction.Instruction;
import ch07.instructions.factory.Factory;
import ch07.rtda.Frame;
import ch07.rtda.Thread;
import ch07.rtda.heap.Method;
import com.sun.org.apache.xpath.internal.SourceTree;
import org.joou.UByte;
import org.joou.UInteger;
import org.joou.UShort;

import java.util.Arrays;

public class interpreter {

    public static void interpret(Method method,boolean logInst) {
        Thread thread=Thread.newThread();
        Frame frame=thread.newFrame(method);
        thread.pushFrame(frame);
        //try {
            loop(thread, method.code,logInst);
        /*}catch (Exception e){
            catchErr(thread);
        }*/
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

          //  System.out.printf("pc:%2d,  instruction:%s oprand:%s\n",pc,inst.getClass(),inst.index);
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
