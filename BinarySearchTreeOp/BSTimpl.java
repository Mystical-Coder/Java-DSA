package BinarySearchTreeOp;

import java.util.ArrayList;

public class BSTimpl {

    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }
        if (root.data > val)
            root.left = insert(root.left, val);
        else
            root.right = insert(root.right, val);
        return root;
    }

    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static boolean search(Node root, int val) {
        if (root == null)
            return false;
        if(root.data == val)
            return true;
        if(root.data > val)
            return search(root.left, val);
        else   
            return search(root.right, val);
    }

    public static Node delete(Node root, int val){
        if(root.data < val){
            root.right = delete(root.right, val);
        }else if(root.data > val){
            root.left = delete(root.left, val);
        }else{
            if(root.left == null && root.right == null){
                return null;
            }
            if(root.left == null){
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }
            Node Is = findInorderSucessor(root.right);
            root.data = Is.data;
            root.right = delete(root.right, Is.data);
        }
        return root;
    }

    public static Node findInorderSucessor(Node root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }



    public static void printRange(Node root, int k1, int k2){
        if(root == null)
            return;
        if(root.data >= k1 && root.data <= k2){
            printRange(root.left, k1, k2);
            System.out.print(root.data+" ");
            printRange(root.right, k1, k2);
        }else if(root.data < k1){
            printRange(root.left, k1, k2);
        }else{
            printRange(root.right, k1, k2);
        }
    }

    public static void printPath(ArrayList<Integer> list){
        for(int val : list){
            System.out.print(val +"->");
        }
        System.out.println("Null");
    }

    public static void printRoot2Leaf(Node root, ArrayList<Integer> list){
        if(root == null)
            return;
        list.add(root.data);
        if(root.left == null && root.right == null)
            printPath(list);
        printRoot2Leaf(root.left, list);
        printRoot2Leaf(root.right, list);
        list.remove(list.size() - 1);
    }

    public static boolean isValid(Node root, Node min, Node max){
        if(root == null)
            return true;
        if(min != null && root.data <= min.data)
            return false;
        else if(max != null && root.data >= max.data)
            return false;
        return isValid(root.left, min, root) && isValid(root.right, root, max);
    }

    public static void main(String[] args) {
        // int values[] = { 5, 1, 3, 4, 2, 7 };
        int values[] = {8, 5, 3, 1, 4, 6, 10, 11, 14};
        Node root = null;
        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }

        inorder(root);
        System.out.println();
        // System.out.println(search(root, 14));
        // root = delete(root, 1); // leaf node case
        // root = delete(root, 10); // Single children node case
        // root = delete(root, 5); // Two children node case
        // inorder(root); 
        // printRange(root, 5, 12);
        // printRoot2Leaf(root, new ArrayList<>());
        System.out.println(isValid(root, null, null));
    }
}
