package ch04.rtda;

import org.junit.jupiter.api.Test;

import java.lang.Object;


class grandpa{


}

class father extends grandpa{
    int index;

}
class son extends father{
    void g(){
        System.out.println(index);
    }
    void s(){
        index=4444;
    }
}
class LocalVarsTest {

    @Test
    void setRef() {
        Object obj=3.43;
        System.out.println(obj.getClass());
    }
}