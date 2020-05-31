package com.home;

public class BSTTest {

    private Node root;
    private class Node {
        int data;
        Node left;
        Node right;
        public Node(int data) { this.data = data; }
        public int getData() { return this.data; }
    }

    public static void main(String args[]) {

        BSTTest object = new BSTTest();

        object.root = object.insert(object.root, 15);
        object.insert(object.root, 10);
        object.insert(object.root, 20);
        object.insert(object.root, 12);
        object.insert(object.root, 22);
        object.insert(object.root, 8);
        object.insert(object.root, 18);

        /*obj.insert(15);
        obj.insert(10);
        obj.insert(20);
        obj.insert(12);
        obj.insert(22);
        obj.insert(8);
        obj.insert(18);
*/
        System.out.println("22 exist? "+object.search(object.root, 22));
        System.out.println("pre");
        preorder(object.root);
        System.out.println("\nin");
        inorder(object.root);
        System.out.println("\ndpost");
        postorder(object.root);
    }

    private static void preorder(Node root) {
        if(root == null) return;
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }

    private static void postorder(Node root) {
        if(root == null) return;
        preorder(root.left);
        preorder(root.right);
        System.out.print(root.data+" ");
    }

    private static void inorder(Node root) {
        if(root == null) return;
        preorder(root.left);
        System.out.print(root.data+" ");
        preorder(root.right);
    }

    private boolean search(Node root, int data) {

        if(root == null) return false;
        if(data < root.data) return search(root.left, data);
        if(data > root.data) return search(root.right, data);
        if(data == root.data) return true;
        return false;
    }

    private Node insert(Node root, int data) {
        if(root == null){
            root = new Node(data);
        }else if(data < root.data){
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }
        return root;
    }
}
