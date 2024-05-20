package QueueOp;

public class CircularQueueArr {
    
    public static class Queue {
        static int[] arr;
        static int size;
        static int front;
        static int rear;

        public Queue(int size){
            arr = new int[size];
            this.size = size;
            front = -1;
            rear = -1;
        }

        public static boolean isEmpty(){
            return rear == -1 && front == -1;
        }

        public static boolean isFull(){
            return (rear + 1) % size == front;
        }

        public static void add(int val){
            if(isFull()){
                System.out.println("Queue is Full");
            }
            if(front == -1){
                front = 0;
            }
            rear = (rear + 1) % size;
            arr[rear] = val;
        }

        public static int remove(){
            if(isEmpty()){
                System.out.println("Queue is Empty");
                return -1;
            }
            int val = arr[front];
            if(front == rear){
                front = rear = -1;
            }else{
                front = (front + 1) % size;
            }
            return val;
        }

        public static int peek(){
            if(isEmpty()){
                System.out.println("Queue is Empty");
                return -1;
            }
            return arr[front];
        }

    }

    public static void main(String[] args) {
        Queue queue = new Queue(3);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println(queue.remove());
        queue.add(4);
        System.out.println(queue.remove());
        queue.add(5);
        
        while(!queue.isEmpty()){
            System.out.println(queue.peek());
            queue.remove();
        }
        
    }

}
