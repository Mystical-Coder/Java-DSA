package BinarySearchTreeOp;

import java.util.ArrayList;

public class MergeBst {

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

    public static void inorder(Node root, ArrayList<Integer> list){
        if(root == null)
            return;
        inorder(root.left, list);
        list.add(root.data);
        inorder(root.right, list);
    }

    public static Node createBst(ArrayList<Integer> list, int low, int high){
        if(low > high){
            return null;
        }
        int mid = (low + high)/2;
        Node node = new Node(list.get(mid));
        node.left = createBst(list, low, mid - 1);
        node.right = createBst(list, mid + 1, high);
        return node;
    }

    public static Node mergeBST(Node root1, Node root2){
        ArrayList<Integer> list1 = new ArrayList<>();
        inorder(root1, list1);
        ArrayList<Integer> list2 = new ArrayList<>();
        inorder(root2, list2); 
        int i = 0, j = 0;
        ArrayList<Integer> finalList = new ArrayList<>();
        while(i < list1.size() && j < list2.size()){
            if(list1.get(i) <= list2.get(j)){
                finalList.add(list1.get(i));
                i++;
            }else{
                finalList.add(list2.get(j));
                j++;
            }
        }
        while(i < list1.size()){
            finalList.add(list1.get(i));
            i++;
        }
        while(j < list2.size()){
            finalList.add(list2.get(j));
            j++;
        }
        Node node = createBst(finalList, 0, finalList.size() -1);
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
        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(4);

        Node root2 = new Node(9);
        root2.left = new Node(3);
        root2.right = new Node(12);

        Node root = mergeBST(root1, root2);
        preorder(root);
    }
}
