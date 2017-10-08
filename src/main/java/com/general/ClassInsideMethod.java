package com.general;


import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executors;

class p {

    p(){
        System.out.println("p constructor");
    }
    void m(){
        System.out.println("p");
    }
}

class c extends p {

    c(){
        System.out.println("c constructor");
    }
    void m(){
        System.out.println("c");
    }
}

public class ClassInsideMethod
{
    public static void main(String[] args)
    {

        p o = new c();
        o.m();

        ClassInsideMethod t = new ClassInsideMethod();
//        testMethod();

        //Executors.

        Set<Integer> s = new HashSet<>();
        s.add(1);
        s.add(2);
        s.add(3);
        s.add(4);
        s.add(null);

        Iterator<Integer> iterator = s.iterator();
        while(iterator.hasNext()){
            int i = iterator.next();
            System.out.println(i);
        }
    }

    private static void testMethod(){
        abstract class TestMethod{
            int a;
            int b;
            int c;

            abstract void implementMe();
        }

        class DummyClass extends TestMethod{
            void implementMe(){
                System.out.println("Dummy");
            }
        }

        DummyClass dummy = new DummyClass();
        dummy.implementMe();
    }
}