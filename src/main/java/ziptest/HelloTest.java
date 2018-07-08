package ziptest;

import com.sun.org.apache.xalan.internal.xsltc.dom.SortingIterator;
import org.joou.UInteger;
import static org.joou.Unsigned.*;
import org.junit.jupiter.api.Test;
import org.omg.CORBA.PUBLIC_MEMBER;
import sun.java2d.SurfaceDataProxy;

import javax.sound.midi.Soundbank;
import java.lang.annotation.AnnotationFormatError;
import java.util.Stack;

class Animal{
    UInteger uInteger=uint(220);
    int a,b,c,d;

    public Animal(int a, int b, int c, int d) {
        uInteger=uInteger.add(3);
                this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                ", d=" + d +
                '}';
    }
}

public class HelloTest {
    public static void main(String[] args) {
        int i=0;
        Stack<Integer> stack=new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        Animal animal=new Animal(stack.pop(),stack.pop(),stack.pop(),stack.pop());
        System.out.println(animal.uInteger);
        UInteger uInteger=uint(0);


    }



}