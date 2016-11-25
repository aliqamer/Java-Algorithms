package com.interview;

/**
 * Created by Ali on 10/3/2016.
 */
public class DoubliLinkedList<T> {

    Node head;
    Node tail;

    class Node<T> {
        Node next;
        Node prev;
        T data;

        public Node(T data){
            this.data = data;
        }
    }

    public void add(T data){

        Node<T> newNode = new Node<>(data);

        if(head == null){
            tail = head = newNode;
            head.next = head.prev = null;
            return;
        }
        newNode.prev = tail;
        tail.next = newNode;
        tail = newNode;
    }

    public static void main(String args[]){
        DoubliLinkedList<Integer> doubliLinkedList = new DoubliLinkedList<>();

        doubliLinkedList.add(10);
        doubliLinkedList.add(20);
        doubliLinkedList.add(30);
        doubliLinkedList.add(40);
        doubliLinkedList.add(50);
        doubliLinkedList.add(60);

        System.out.println("\n1");
        doubliLinkedList.reverseTraverse(doubliLinkedList.tail);

        DoubliLinkedList<Integer> doubliLinkedList2 = new DoubliLinkedList<>();

        doubliLinkedList2.add(10);
        doubliLinkedList2.add(20);
        doubliLinkedList2.add(30);
        doubliLinkedList2.add(40);
        doubliLinkedList2.add(50);
        doubliLinkedList2.add(60);

        System.out.println("\n2");
        doubliLinkedList.reverseTraverse(doubliLinkedList2.tail);
        System.out.println("\n3");
        doubliLinkedList.traverse(doubliLinkedList2.head);

    }

    private void reverseTraverse(Node<Integer> tail) {
        Node n = tail;
        while(n != null){
            System.out.print(n.data + " ");
            n = n.prev;
        }
    }

    private void traverse(Node<Integer> head) {
        Node n = head;
        while(n != null){
            System.out.print(n.data + " ");
            n = n.next;
        }
    }
}
