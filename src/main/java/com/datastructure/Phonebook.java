package com.datastructure;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Ali on 11/13/2016.
 */

class AddressBook implements Comparable<AddressBook>{

    private String number;
    private String name;
    private String Address;

    public AddressBook(String number, String name, String address) {
        this.number = number;
        this.name = name;
        Address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public boolean equals(AddressBook o){
        if(o == null){
            return false;
        }
        if(getClass() != o.getClass()){
            return false;
        }
        if(this == o){
            return true;
        }
        if(o.number.compareTo(this.number) == 0){
            if(o.name != null && o.name.compareTo(this.name) == 1){
                return true;
            }
        }
        return false;
    }


    @Override
    public int hashCode() {
        int hash = number.hashCode() * 31 + name.hashCode() * 7;
        return hash;
    }

    @Override
    public int compareTo( AddressBook o2) {
        if(this.name.toLowerCase().compareTo(o2.name.toLowerCase()) == 0){
            return this.number.compareTo(o2.number);
        }
        return this.name.toLowerCase().compareTo(o2.name.toLowerCase());
    }

    @Override
    public String toString(){
        return String.format("%s: %s : %s", name, number, getAddress());
    }
}

class nameComparator implements Comparator<AddressBook>{

    public int compare(AddressBook o1, AddressBook o2){
        if(o1.getName().toLowerCase().compareTo(o2.getName().toLowerCase()) == 0){
            return o1.getNumber().compareTo(o2.getNumber());
        }
        return o1.getName().compareToIgnoreCase(o2.getName());
    }
}

public class Phonebook {

    public static void main(String args[]) {

//        Queue<AddressBook> addressBook = new PriorityQueue<>(new nameComparator());
        Queue<AddressBook> addressBook = new PriorityQueue<>();
//        List<AddressBook> addressBook = new ArrayList<>();
        addressBook.add(new AddressBook("9851","Soleh",null));
        addressBook.add(new AddressBook("9850","Ali",null));
        addressBook.add(new AddressBook("9852","qamer",null));
        addressBook.add(new AddressBook("9855","Amir",null));
        addressBook.add(new AddressBook("9856","salma",null));
        addressBook.add(new AddressBook("9853","Shaik",null));
        addressBook.add(new AddressBook("9857","Soleman",null));

        System.out.println(addressBook);

        LinkedList<String>[] item;
//        Object<T>[] items;
//        List<AddressBook> list = new ArrayList<>(addressBook);
//        Collections.sort(list, new nameComparator());
//        System.out.println(addressBook);
    }
}
