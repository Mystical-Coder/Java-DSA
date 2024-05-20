package StackOp;

import java.util.LinkedList;
import java.util.Queue;

public class Stack2Queue {

    public static class Stack {
        static Queue<Integer> queue1 = new LinkedList<>();
        static Queue<Integer> queue2 = new LinkedList<>();

        public static boolean isEmpty() {
            return queue1.isEmpty() && queue2.isEmpty();
        }

        public static void push(int val) {
            if (!queue1.isEmpty()) {
                queue1.add(val);
            } else {
                queue2.add(val);
            }
        }

        public static int pop() {
            if (isEmpty()) {
                return -1;
            }
            int top = -1;
            if (!queue1.isEmpty()) {
                while (!queue1.isEmpty()) {
                    top = queue1.remove();
                    if (queue1.isEmpty()) {
                        break;
                    }
                    queue2.add(top);
                }
            } else {
                while(!queue2.isEmpty()){
                    top = queue2.remove();
                    if(queue2.isEmpty()){
                        break;
                    }
                    queue1.add(top);
                }
            }
            return top;
        }
        public static int peek() {
            if (isEmpty()) {
                return -1;
            }
            int top = -1;
            if (!queue1.isEmpty()) {
                while (!queue1.isEmpty()) {
                    top = queue1.remove();
                    queue2.add(top);
                }
            } else {
                while(!queue2.isEmpty()){
                    top = queue2.remove();
                    queue1.add(top);
                }
            }
            return top;
        }

    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.pop();
        while (!stack.isEmpty()) {
            System.out.println(stack.peek());
            stack.pop();
        }
    }
}
