package StackOp;

public class StackImpLL {

    public static class Node {
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static class Stack {
        public static Node head = null;

        public static boolean isEmpty(){
            return head == null;
        }

        public static void push(int val){
            Node newNode = new Node(val);
            if(isEmpty()){
                head = newNode;
                return;
            }
            newNode.next = head;
            head = newNode;
        }

        public static int pop(){
            if(isEmpty()){
                return -1;
            }
            int val = head.data;
            head = head.next;
            return val;
        }

        public static int peek(){
            return head.data;
        }

    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        while(!stack.isEmpty()){
            System.out.print(stack.peek()+" ");
            stack.pop();
        }

    }
}
