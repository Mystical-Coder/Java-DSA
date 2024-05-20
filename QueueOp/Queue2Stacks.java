package QueueOp;

import java.util.Stack;

public class Queue2Stacks {
    public static class Queue { //push : O(n) and pop & peek: O(1)
        static Stack<Integer> stack1 = new Stack<>();
        static Stack<Integer> stack2 = new Stack<>();

        public static boolean isEmpty() {
            return stack1.isEmpty();
        }

        public static void add(int val) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            stack1.push(val);
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }

        }

        public static int remove() {
            if(isEmpty()){
                System.out.println("Queue is Empty");
                return -1;
            }
            return stack1.pop();
        }

        public static int peek() {
            if(isEmpty()){
                System.out.println("Queue is Empty");
                return -1;
            }
            return stack1.peek();
        }
    }

    public static class Queue1{ // push : O(1) and pop & peek:O(n)
        private static Stack<Integer> stack1 = new Stack<>();
        private static Stack<Integer> stack2 = new Stack<>();

        public static boolean isEmpty(){
            return stack1.isEmpty();
        }

        public static void add(int val){
            stack1.push(val);
        }

        public static int remove(){
            if(isEmpty()){
                return -1;
            }
            while(stack1.size() > 1){
                stack2.push(stack1.pop());
            }
            int front = stack1.pop();
            while(!stack2.isEmpty()){
                stack1.push(stack2.pop());
            }
            return front;
        }
        public static int peek(){
            if(isEmpty()){
                return -1;
            }
            while(stack1.size() > 1){
                stack2.push(stack1.pop());
            }
            int peek = stack1.peek();
            while(!stack2.isEmpty()){
                stack1.push(stack2.pop());
            }
            return peek;
        }
    }

  

    public static void main(String[] args) {
        // Queue queue = new Queue(); 
        // queue.add(1);
        // queue.add(2);
        // queue.add(3);
        // queue.remove();
        // queue.add(4);
        // while (!queue.isEmpty()) {
        //     System.out.println(queue.peek());
        //     queue.remove();
        // }

        Queue1 queue1 = new Queue1();
        queue1.add(1);
        queue1.add(2);
        queue1.add(3);

        while (!queue1.isEmpty()) {
            System.out.println(queue1.peek());
            queue1.remove();
        }
    }
}
