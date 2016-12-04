package com.home;

/**
 * Hello world!
 *
 */

class A{
    public void test(){
        System.out.println("A");
    }

    public static void A() {
        System.out.println("In A");
    }
}

class B extends A{
    public void test(){
        System.out.println("B");
    }
}

public class App 
{
    public static void main( String[] args )
    {

        System.out.println( "Hello World!" );
        A o = new B();
        o.test();

        StringBuffer sb = new StringBuffer("Hello");
        sb.setCharAt(1,'x');
        System.out.println(sb);

    }

    public static void main(char[] chars){

    }
}
