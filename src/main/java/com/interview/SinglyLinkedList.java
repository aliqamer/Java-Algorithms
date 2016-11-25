package com.interview;

/**
 * Created by Ali on 10/2/2016.
 */
public class SinglyLinkedList<T> {

    Node<T> head;
    Node<T> tail;

    class Node<T> {
        T data;
        Node<T> next;
        Node(T data){
            this.data = data;
        }
    }

    void add(T data) {
        Node current = new Node(data);

        if(head == null){
            head = tail = current;
        }else {
            tail.next = current;
            tail = current;
        }
    }

    void printList(){
        Node n = head;
        while(n != null){
            System.out.println(n.data);
            n = n.next;
        }
    }

    public static void main(String args[]){
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
        linkedList.add(10);
        linkedList.add(20);
        linkedList.add(30);
        linkedList.add(40);
        linkedList.add(50);
        linkedList.add(60);

        linkedList.printList();

//        linkedList.delete(10);

//        linkedList.printList();
    }

}
