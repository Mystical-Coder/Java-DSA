package LinkedListOp;

public class ZigZag {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data) { // O(1)
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public void printLL() {
        if (head == null) {
            System.out.println("Linked list is empty");
            return;
        }
        Node trav = head;
        while (trav != null) {
            System.out.print(trav.data + "->");
            trav = trav.next;
        }
        System.out.println("null");
    }

    public void zigzag(){
        // Find middle element in linkedlist
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;
        // Reverse second half of linked list
        Node curr = mid.next;
        mid.next = null;
        Node prev = null;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // Zig Zag logic

        Node left = head;
        Node right = prev;
        Node nextL, nextR;
        while(left != null && right != null){
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;
            left = nextL;
            right = nextR;
        }
    }

    public static void main(String[] args) {
        ZigZag ll = new ZigZag();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        // ll.addLast(5);
        ll.printLL();
        ll.zigzag();
        ll.printLL();
    }
}
