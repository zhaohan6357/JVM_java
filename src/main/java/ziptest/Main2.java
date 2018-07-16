package ziptest;

class base{
    public void test(){

    }
}
class sub extends Main2{

}
public class Main2  extends base{
    public static void main(String[] args) {
        sub sub=new sub();
        sub.test();
    }
}

