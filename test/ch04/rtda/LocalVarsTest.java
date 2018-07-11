package ch04.rtda;

import org.junit.jupiter.api.Test;


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
        grandpa g=new son();

        System.out.println(g.getClass());
    }
}