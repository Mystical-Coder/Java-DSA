package BinarySearchTreeOp;

public class SortedArrToBST {
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

    public static Node creatBST(int[] arr, int low, int high){
        if(low > high)
            return null;
        int mid = (low + high)/2;
        Node root = new Node(arr[mid]);
        root.left = creatBST(arr, low, mid - 1);
        root.right = creatBST(arr, mid + 1, high);
        return root;
    }
    public static void preorder(Node root){
        if(root == null)
            return;
        System.out.print(root.data +" ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void main(String[] args) {
        int[] arr = {3, 5, 6, 8, 10, 11, 12};
        Node root = creatBST(arr, 0, arr.length - 1);
        preorder(root);
    }

}
