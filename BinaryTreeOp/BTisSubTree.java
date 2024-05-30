package BinaryTreeOp;

public class BTisSubTree {

    public static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static boolean isIdentical(Node root, Node sub){
        if(root == null && sub == null){
            return true;
        }else if(root == null || sub == null || root.data != sub.data){
            return false;
        }
        if(!isIdentical(root.left, sub.left)){
            return false;
        }
        if(!isIdentical(root.right, sub.right)){
            return false;
        }
        return true;
    }

    public static boolean isSubTree(Node root, Node sub){
        if(root == null){
            return false;
        }
        if(root.data == sub.data){
            if(isIdentical(root, sub)){
                return true;
            }
        }
        return isSubTree(root.left, sub) || isSubTree(root.right, sub); 
    }


    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        Node subtree = new Node(2);
        subtree.left = new Node(4);
        // subtree.right = new Node(5);
        System.out.println(isSubTree(root, subtree));
    }
}
