package com.home;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Ali on 9/25/2016.
 */
public class BinarySearchTree {

    private Node root;
    private class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }
    }

    public static void main(String str[]){

        List<String> o = new LinkedList<>();
        BinarySearchTree obj = new BinarySearchTree();

        obj.insert(15);
        obj.insert(10);
        obj.insert(20);
        obj.insert(12);
        obj.insert(22);
        obj.insert(8);
        obj.insert(18);

        /*obj.root = obj.insert(obj.root, 15);
        obj.insert(obj.root, 10);
        obj.insert(obj.root, 20);
        obj.insert(obj.root, 12);
        obj.insert(obj.root, 22);
        obj.insert(obj.root, 8);
        obj.insert(obj.root, 18);*/

        boolean isPresent = obj.search(obj.root, 22);
        System.out.println(isPresent);
        System.out.println("DFT");
        obj.BFT(obj.root);
        System.out.println("\nPre Order BFT");
        obj.preOrderDFT(obj.root);
        System.out.println("\nIn Order BFT");
        obj.inOrderDFT(obj.root);
        System.out.println("\nPost Order BFT");
        obj.postOrderDFT(obj.root);
    }

    public void preOrderDFT(Node root){
        if(root == null) {
            return;
        }
        System.out.print(root.data+" ");
        preOrderDFT(root.left);
        preOrderDFT(root.right);
    }

    public void inOrderDFT(Node root){
        if(root == null) {
            return;
        }
        preOrderDFT(root.left);
        System.out.print(root.data+" ");
        preOrderDFT(root.right);
    }

    public void postOrderDFT(Node root){
        if(root == null) {
            return;
        }
        preOrderDFT(root.left);
        preOrderDFT(root.right);
        System.out.print(root.data+" ");
    }

    public void BFT(Node root){

        if(root == null)
            return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node current = queue.poll();
            if(current != null) {
                System.out.print(current.data+" ");
            }else {
                continue;
            }
            if(current.left != null) {
                queue.add(current.left);
            }
            if(current.right != null) {
                queue.add(current.right);
            }
        }
    }

    public Node insert(Node root, int data) {
        if(root == null) {
            root = getNewNode(data);
        }else if(data <= root.getData()) {
            root.left = insert(root.left, data);
        }else {
            root.right = insert(root.right, data);
        }
        return root;
    }

    private void insert(int data) {
        root = insert(root, data);
    }


    public boolean search(Node root, int data){
        if(root == null) return false;
        else if(root.getData() == data) return true;
        else if(data < root.getData() ) return search(root.left, data);
        else return search(root.right, data);
    }

    private Node getNewNode(int data) {
        Node node = new Node(data);
        node.left = null;
        node.right = null;
        return node;
    }
}
