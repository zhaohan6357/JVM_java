package ch04.rtda;

import org.joou.UInteger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LocalVarsTest {

    @Test
    void setRef() {
        int i = 255;
        int v = (int) ((byte) i);
        System.out.println(v);
    }
}