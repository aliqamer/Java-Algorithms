package com.general;


// A Java program to demonstrate that both super class
// and subclass constructors refer to same object

// super class
class Fruit
{
    public Fruit()
    {
        System.out.println("Super class constructor");
        System.out.println("Super class object hashcode :" +
                this.hashCode());
        System.out.println(this.getClass().getName());
    }
}

// sub class
class Apple extends Fruit
{
    public Apple()
    {
        System.out.println("Subclass constructor invoked");
        System.out.println("Sub class object hashcode :" +
                this.hashCode());
        System.out.println(this.hashCode() + "   " +
                super.hashCode());

        System.out.println(this.getClass().getName() + "  " +
                super.getClass().getName());
    }
}

public class ObjectCreationTest {

    public static void main(String[] args)
    {
        Apple myApple = new Apple();
    }
}
