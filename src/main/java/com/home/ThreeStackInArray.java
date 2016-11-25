package com.home;

/**
 * Created by Ali on 10/9/2016.
 */
public class ThreeStackInArray {

    private int[] buffer;
    private int[] stackPointers = {-1,-1,-1};
    private int stackSize;


    public static void main(String args[]) throws Exception {

        ThreeStackInArray object = new ThreeStackInArray();
        object.createStacks(100);
        object.push(0,5);
        object.push(1,8);
        object.push(2,10);
        object.push(0,10);
        object.push(1,15);
        object.push(2,19);
        object.push(2,20);

        int value = object.pop(0);
        System.out.println(value);
        value = object.pop(1);
        System.out.println(value);
        value = object.pop(2);
        System.out.println(value);
        object.push(0,50);
        object.push(0,20);
        object.push(1,30);
        value = object.pop(0);
        System.out.println(value);
        value = object.pop(1);
        System.out.println(value);
        value = object.pop(1);
        System.out.println(value);
        value = object.pop(1);
        System.out.println(value);

    }

    private int pop(int stack) throws Exception {

        if(stackPointers[stack]+ (stack*stackSize) <  (stack*stackSize )){
            throw new Exception("Underflow exception");
        }

        return buffer[stackPointers[stack]-- + (stack*stackSize)];
    }

    private void push(int stack, int value) throws Exception {
        if(stackPointers[stack] >= stackSize){
            throw new Exception("Stack is full");
        }
        stackPointers[stack]++;
        buffer[stackSize*stack+stackPointers[stack]] = value;
    }

    private void createStacks(int stackSize) {
        this.buffer = new int[stackSize * 3];
        this.stackSize = stackSize;
    }


}
