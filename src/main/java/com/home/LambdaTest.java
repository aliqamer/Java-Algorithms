package com.home;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

class Person{
    private String fname;
    private String lname;
    private int age;

    public Person(String fname, String lname, int age) {
        this.fname = fname;
        this.lname = lname;
        this.age = age;
    }

    public String getLname() {
        return lname;
    }

    @Override
    public String toString() {
        return "Person{" + "fname='" + fname + '\'' + ", lname='" + lname + '\'' + ", age=" + age + '}';
    }
}

public class LambdaTest {

    public static void main(String args[]) {

        LambdaTest object = new LambdaTest();

        MyLambda myLambda = () -> System.out.println("Hello world");
        myLambda.anyMethodName();

        MyAdd addLambda = (int a, int b) -> a + b;

        System.out.println(addLambda.add(4,5));

        System.out.println(fun((a,b) -> a + b,5 ,4));

        //test lambda with predicate
        List<Person> persons = Arrays.asList(
          new Person("john","brown",40),
          new Person("adam","brunner",30),
          new Person("lowry","depp",34),
          new Person("shawn","cruise",36)
        );

        //sort by last name
        Collections.sort(persons, (p1,p2)-> p1.getLname().compareTo(p2.getLname()));

        //print all persons
        System.out.println("print all sorted persons");
        printConditionally(persons, p -> true);

        System.out.println("\nprint all person whose last name start with b");
        printConditionally(persons, p -> p.getLname().startsWith("b"));
    }

    private static void printConditionally(List<Person> persons, Predicate<Person> predicate) {
        for (Person p : persons) {
            if(predicate.test(p)){
                System.out.println(p);
            }
        }
    }

    private static int fun(MyAdd expr, int a, int b) {
        return expr.add(a , b);
    }
}

interface MyLambda{
    void anyMethodName();
}

interface MyAdd {
    int add(int a, int b);
}