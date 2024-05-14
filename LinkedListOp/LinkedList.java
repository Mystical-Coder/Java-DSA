package LinkedListOp;

public class LinkedList {
    
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data){ // O(1)
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public void printLL(){
        if(head == null){
            System.out.println("Linked list is empty");
            return;
        }
        Node trav = head;
        while (trav != null) {
            System.out.print(trav.data +"->");
            trav = trav.next;
        }
        System.out.println("null");
    }

    public void add(int indx, int data){
        if(indx == 0){
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;
        while(i < indx - 1){
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public int removeFirst(){
        if(size == 0){
            System.out.println("Linked list is empty");
            return Integer.MIN_VALUE;
        }else if(size == 1){
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public int removeLast(){
        if(size == 0){
            System.out.println("Linked list is empty");
            return Integer.MIN_VALUE;
        }else if(size == 1){
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        Node temp = head;
        for(int i = 0 ;i < size - 2; i++){
            temp = temp.next;
        }
        int val = temp.next.data;
        temp.next = null;
        tail = temp;
        size--;
        return val;
    }

    public int search(int val){
        if(size == 0){
            System.out.println("Linked list is empty");
            return Integer.MIN_VALUE;
        }
        Node temp = head;
        int i = 0;
        while(temp != null){
            if(temp.data == val){
                return i;
            }
            i++;
            temp = temp.next;
        }
        return -1;
    }

    public int helper(Node head, int val){
        if(head == null){
            return -1;
        }
        if(head.data == val){
            return 0;
        }
        int indx = helper(head.next, val);
        if(indx == -1){
            return -1;
        }
        return indx + 1;
    }

    public int recSearch(int val){
        return helper(head, val);
    }

    public void reverse(){
        Node prev = null;
        Node curr = tail = head;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public void removeNthFromEnd(int indx){
        int sz = 0;
        Node temp = head;
        while(temp != null){
            temp = temp.next;
            sz++;
        }
        if(sz == indx){
            head = head.next;
            return;
        }
        int i = 1;
        int findIndx = sz - indx;
        Node prev = head;
        while(i < findIndx){
            prev = prev.next;
            i++;
        } 
        prev.next = prev.next.next;
        return;
    }

    public Node findMiddle(Node head){
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public boolean isPalindrome(){
        if(head == null || head.next == null){
            return true;
        }
        Node middle = findMiddle(head);
        Node prev = null;
        Node curr = middle;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr =next;
        }

        Node right = prev;
        Node left = head;

        while(right != null){
            if(left.data != right.data){
                return false;
            }
            right = right.next;
            left = left.next;
        }
        return true;
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
    //     ll.addFirst(1);
    //     ll.addFirst(2);
    //     ll.addLast(3);
    //     ll.addLast(4);
    //     ll.add(3, 8);
    //    ll.printLL();
    //    ll.reverse();
    //    ll.printLL();
        // ll.removeNthFromEnd(3);
        // ll.printLL();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(2);
        System.out.println(ll.isPalindrome());
    }

}
