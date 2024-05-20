package QueueOp;

import java.util.LinkedList;
import java.util.Queue;

public class InterleaveQueue {

    public static void interleavedQueue(Queue<Integer> queue){
        Queue<Integer> queue2 = new LinkedList<>();
        int val = queue.size();
        for(int i = 0; i < val / 2; i++){
            queue2.add(queue.remove());
        }
        while(!queue2.isEmpty()){
            queue.add(queue2.remove());
            queue.add(queue.remove());
        }
        System.out.println(queue);
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= 10; i++){
            queue.add(i);
        }
        interleavedQueue(queue);
    }
}
