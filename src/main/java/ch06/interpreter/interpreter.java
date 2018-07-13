package ch06.interpreter;

import ch06.classfile.CodeAttribute;
import ch06.classfile.ExceptionTableEntry;
import ch06.classfile.MemberInfo;
import ch06.instructions.base.ByteCodeReader;
import ch06.instructions.base.instruction.Instruction;
import ch06.instructions.factory.Factory;
import ch06.rtda.Frame;
import ch06.rtda.Thread;
import ch06.rtda.heap.Method;
import org.joou.UByte;
import org.joou.UInteger;
import org.joou.UShort;

import java.util.Arrays;

public class interpreter {
/*    func interpret(method *heap.Method) {
        thread := rtda.NewThread()
        frame := thread.NewFrame(method)
        thread.PushFrame(frame)

        defer catchErr(frame)
                loop(thread, method.Code())
    }*/

    public static void interpret(Method method) {
        Thread thread=Thread.newThread();
        Frame frame=thread.newFrame(method);
        thread.pushFrame(frame);

            loop(thread,method.code);


    }

    /*func catchErr(frame *rtda.Frame) {
        if r := recover(); r != nil {
            fmt.Printf("LocalVars:%v\n", frame.LocalVars())
            fmt.Printf("OperandStack:%v\n", frame.OperandStack())
            panic(r)
        }
    }*/


    /*func loop(thread *rtda.Thread, bytecode []byte) {
        frame := thread.PopFrame()
        reader := new base.BytecodeReader();
        for {
            pc := frame.NextPC()
            thread.SetPC(pc)
// decode
            reader.Reset(bytecode, pc)
            opcode := reader.ReadUint8()
            inst := instructions.NewInstruction(opcode)
            inst.FetchOperands(reader)
            frame.SetNextPC(reader.PC())
// execute
            fmt.Printf("pc:%2d inst:%T %v\n", pc, inst, inst)
            inst.Execute(frame)
        }
    }*/
    public static void loop(Thread thread,byte[] code){
        Frame frame=thread.popFrame();
        int pc;
        UByte opcode;
        Instruction inst;
        ByteCodeReader reader=new ByteCodeReader();
        for(;;){
            pc=frame.nextPC;
            thread.setPc(pc);
            reader.reset(code,pc);
            opcode=reader.readUint8();
            inst= Factory.newInstruction(opcode);
            inst.FetchOperands(reader);
            frame.setNextPC(reader.pc);
            System.out.printf("pc:%2d,  instruction:%s oprand:%s\n",pc,inst.getClass(),inst.index);
            inst.Execute(frame);
        }

    }

}
