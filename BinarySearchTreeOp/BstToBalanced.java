package BinarySearchTreeOp;

import java.util.ArrayList;

public class BstToBalanced {

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
    public static void getInorder(Node root, ArrayList<Integer> list){
        if(root == null)
            return;
        getInorder(root.left, list);
        list.add(root.data);
        getInorder(root.right, list);
    }

    public static Node createBST(ArrayList<Integer> list, int low, int high){
        if(low >  high)
            return null;
        int mid = (low + high) / 2;
        Node root = new Node(list.get(mid));
        root.left = createBST(list, low, mid - 1);
        root.right = createBST(list, mid+1, high);
        return root;
    }

    public static Node balancedBst(Node root){
        ArrayList<Integer> list = new ArrayList<>();
        getInorder(root, list);
        Node node = createBST(list, 0, list.size() - 1);
        return node;
    }
    public static void preorder(Node root){
        if(root == null)
            return;
        System.out.print(root.data +" ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(6);
        root.left.left = new Node(5);
        root.left.left.left = new Node(3);

        root.right = new Node(10);
        root.right.right = new Node(11);
        root.right.right.right = new Node(12);
        root = balancedBst(root);
        preorder(root);
    }
}
