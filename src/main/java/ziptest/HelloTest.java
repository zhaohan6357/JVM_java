package ziptest;

import org.junit.jupiter.api.Test;
import org.omg.CORBA.PUBLIC_MEMBER;

import javax.sound.midi.Soundbank;
import java.lang.annotation.AnnotationFormatError;

class Animal{

    void printName(){

    }
    void getName(){
        printName();
    }

}
class Cat extends Animal{
    void printName(){
        System.out.println("I am cat");
    }


}

class Dog extends Animal{
    void printName(){
        System.out.println("I am dog");
    }


}
public class HelloTest {
    public static void main(String[] args) {
        System.out.println(Float.intBitsToFloat(0x4048F5C3));
    }



}