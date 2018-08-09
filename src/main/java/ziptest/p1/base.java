package ziptest.p1;

public class base{
    {
        System.out.println("init");
        b=33333;
    }
    static {
        System.out.println("static init");
        //a=333;
    }
    public base(){
      //  a=444;
        System.out.println("cons init");
    }

    int b=3;

    public static final int a =1;

}
