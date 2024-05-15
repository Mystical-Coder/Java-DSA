package LinkedListOp;

public class DoublyLinkedList {

    public class Node {
        
        int data;
        Node prev;
        Node next;

        public Node(int data){
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    
    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    public int removeFirst(){
        if(head == null){
            System.out.println("Linked list is empty");
            return Integer.MIN_VALUE;
        }
        if(size == 1){
            head = tail = null;
            size--;
        }
        int val = head.data;
        head = head.next;
        head.prev = null;
        size--;
        return val;
    }

    public void printLL(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+"<->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void reverseLL(){
        Node curr = head;
        Node prev = null;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            curr.prev = next;
            prev = curr;
            curr =next;
        }
       head = prev;
    }

    public static void main(String[] args) {
        DoublyLinkedList ll = new DoublyLinkedList();
        ll.addFirst(3);
        ll.addFirst(2);
        ll.addFirst(1);
        ll.printLL();
        ll.reverseLL();
        ll.printLL();
    }
}
