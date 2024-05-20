package QueueOp;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseQueue {

    public static void reverse(Queue<Integer> queue){
        Stack<Integer> stack = new Stack<>();
        while(!queue.isEmpty()){
            stack.push(queue.remove());
        }
        while(!stack.isEmpty()){
            queue.add(stack. pop());
        }
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList();
        for(int i = 1; i <= 5; i++){
            queue.add(i);
        }
        reverse(queue);
        System.out.println(queue);
    }
}
