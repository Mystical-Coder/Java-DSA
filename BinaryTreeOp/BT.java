package BinaryTreeOp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BT {

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {
        static int indx = -1;

        public static Node builtTree(int[] nodes) {
            indx++;
            if (nodes[indx] == -1) {
                return null;
            }
            Node newNode = new Node(nodes[indx]);
            newNode.left = builtTree(nodes);
            newNode.right = builtTree(nodes);
            return newNode;
        }

        public static void preorder(Node root) {
            if (root == null) {
                return;
            }
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }

        public static void postOrder(Node root) {
            if (root == null) {
                return;
            }
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }

        public static void levelOrder(Node root) {
            if (root == null) {
                return;
            }
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            queue.add(null);
            while (!queue.isEmpty()) {
                Node currNode = queue.remove();
                if (currNode == null) {
                    System.out.println();
                    if (queue.isEmpty()) {
                        break;
                    } else {
                        queue.add(null);
                    }
                } else {
                    System.out.print(currNode.data + " ");
                    if (currNode.left != null) {
                        queue.add(currNode.left);
                    }
                    if (currNode.right != null) {
                        queue.add(currNode.right);
                    }
                }
            }
        }

        public static int height(Node root) { // Counting roots not edges
            if (root == null) {
                return 0;
            }
            int lh = height(root.left);
            int rh = height(root.right);
            return Math.max(lh, rh) + 1;
        }

        public List<List<Integer>> levelOrder1(Node root) {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null)
                return result;
            List<Integer> level = new ArrayList<>();
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                while (size-- > 0) {
                    Node frnt = queue.remove();
                    level.add(frnt.data);
                    if (frnt.left != null) {
                        queue.add(frnt.left);
                    }
                    if (frnt.right != null) {
                        queue.add(frnt.right);
                    }
                }
                result.add(new ArrayList<>(level));
                level.clear();
            }
            return result;
        }

        public static int countNode(Node root) {
            if (root == null)
                return 0;
            int lh = countNode(root.left);
            int rh = countNode(root.right);
            return lh + rh + 1;
        }

        public static int countNodeOptimal(Node root) {
            if (root == null) {
                return 0;
            }

            int lh = findLeftHeight(root);
            int rh = findRightHeight(root);

            if (lh == rh) {
                return (1 << lh) - 1;
            }
            return countNodeOptimal(root.left) + countNodeOptimal(root.right) + 1;
        }

        public static int findLeftHeight(Node node) {
            int height = 0;
            while (node != null) {
                height++;
                node = node.left;
            }
            return height;
        }

        public static int findRightHeight(Node node) {
            int height = 0;
            while (node != null) {
                height++;
                node = node.right;
            }
            return height;
        }

    }

    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        BinaryTree binaryTree = new BinaryTree();
        Node root = binaryTree.builtTree(nodes);
        // binaryTree.preorder(root);

        // binaryTree.postOrder(root);
        // binaryTree.levelOrder(root);
        // System.out.println(binaryTree.height(root));
        // System.out.println(binaryTree.countNode(root));
        System.out.println(binaryTree.countNodeOptimal(root));
    }
}
