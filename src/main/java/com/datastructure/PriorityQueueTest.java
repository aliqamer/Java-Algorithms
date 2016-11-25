package com.datastructure;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Ali on 11/12/2016.
 */
public class PriorityQueueTest {

    static class Item implements Comparable<Item> {

        private int price;
        private String name;

        public Item(String name, int price) {
            this.price = price;
            this.name = name;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public boolean equals(Item item){

            if(!(item instanceof Item)){
                return false;
            }
            Item o = item;
            if(this.name == null || o.name == null || !o.name.equals(this.name)){
                return false;
            }
            if(this.price != o.price){
                return false;
            }
            return true;
        }

        @Override
        public int compareTo(Item i) {
            if (this.price == i.price) {
                return this.name.compareTo(i.name);
            }

            return this.price - i.price;
        }

        @Override
        public String toString() {
            return String.format("%s: $%d", name, price);
        }
    }

    public static void main(String args[]) {

        Queue<Item> items = new PriorityQueue<>();
        items.add(new Item("IPone", 900));
        items.add(new Item("IPad", 1200));
        items.add(new Item("Xbox", 300));
        items.add(new Item("Watch", 200));

        System.out.println("Order of items in PriorityQueueTest");
        System.out.println(items);

        System.out.println("Element consumed from head of the PriorityQueueTest : " + items.poll());
        System.out.println(items);

        System.out.println("Element consumed from head of the PriorityQueue : " + items.poll());
        System.out.println(items);

        System.out.println("Element consumed from head of the PriorityQueue : " + items.poll());
        System.out.println(items);

    }
}
