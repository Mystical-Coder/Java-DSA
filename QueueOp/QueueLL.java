package QueueOp;

public class QueueLL {

    public static class Node {
        int data;
        Node next;
        public  Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static class Queue {
        static Node head = null;
        static Node tail = null;

        public static boolean isEmpty(){
            return head == null && tail == null;
        }

        public static void add(int val){
            Node node = new Node(val);
            if(head == null){
                head = tail = node;
                return;
            }
            tail.next = node;
            tail = tail.next;
        }

        public static int remove(){
            if(head == null){
                System.out.println("Queue is Empty");
                return -1;
            }
            int front = head.data;
            if(head == tail){
                head = tail = null;
            }else{
                head = head.next;
            }
            return front;
        }
        public static int peek(){
            if(head == null){
                System.out.println("Queue is empty");
                return -1;
            }
            return head.data;
        }
    }

   
    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        while(!queue.isEmpty()){
            System.out.println(queue.peek());
            queue.remove();
        }
    }
}
