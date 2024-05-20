package QueueOp;

public class QueueArr {

    public static class Queue {
        static int arr[];
        static int size;
        static int rear;

        public Queue(int size){
            arr = new int[size];
            this.size = size;
            rear = -1;
        }

        public static boolean isEmpty(){
            return rear == -1;  
        }

        public static void add(int val){
            if(rear == size - 1){
                System.out.println("Queue is full");
            }
            rear = rear + 1;
            arr[rear] = val;
        }

        public static int remove(){
            if(isEmpty()){
                System.out.println("Queue is Empty");
                return -1;
            }
            int val = arr[0];
            for(int i = 0; i < rear; i++){
                arr[i] = arr[i + 1];
            }
            rear = rear - 1;
            return val;
        }

        public static int peek(){
            if(isEmpty()){
                System.out.println("Queue is Empty");
                return -1;
            }
            return arr[0];
        }
    }

   

    public static void main(String[] args) {
        Queue queue = new Queue(3);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        while(!queue.isEmpty()){
            System.out.print(queue.peek()+" ");
            queue.remove();
        }
    }
}
