package QueueOp;

import java.util.Deque;
import java.util.LinkedList;

public class DequeStack {

    static class Stack {
        Deque<Integer> deque = new LinkedList<>();

        public void push(int val){
            deque.addLast(val);
        }

        public int pop(){
            return deque.removeLast();
        }

        public int peek(){
            return deque.getLast();
        }

        public boolean isEmpty(){
            return deque.isEmpty();
        }
        
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.pop();
        System.out.println(stack);
    }
}
