
public class customLL {

    private Node head;
    private Node tail;
    private int size;
    public customLL() {
        this.size = 0;
    }

    public int size() {
        return this.size;
    }
    public boolean isEmpty() {
        return this.size == 0;
    }
    public Node getNodeAt(int idx) {
        Node temp = this.head;
        for( int i = 0; i < idx; i++ ) {
            temp = temp.next;
        }
        return temp;
    }
    public void insertRec(int val, int idx)
    {
        head = insertRec(head, val, idx);
    }
    private Node insertRec(Node node, int val, int idx)
    {
        if( idx == 0 )
        {
            Node newNode = new Node(val, node);
            size++;
            return newNode;
        }
        node.next = insertRec(node.next, val, idx - 1);
        return node;
    }
    public void insertAtHead(int data) {
        Node newNode = new Node(data);
        newNode.next = this.head;
        head = newNode;

        if( tail == null ) {
            tail = newNode;
        }
        this.size++;
    }
    public void insertAtTail(int data) {
        Node newNode = new Node(data);
        if( tail == null ) {
            insertAtHead(data); 
            return;
        } 
        tail.next = newNode;
        tail = newNode;
        this.size++;
    }
    public void insertAt(int data, int idx) {
        if( idx == 0 ) {
            insertAtHead(data);
            return;
        }
        if( idx == this.size ) {
            insertAtTail(data);
            return;
        }
        Node newNode = new Node(data);
        Node temp = this.head;
        for( int i = 0; i < idx - 1; i++ ) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        this.size++;
    }
    public void deleteAtHead() {
        if( this.head == null ) {
            tail = null;
            return;
        }
        this.head = this.head.next;
        this.size--;
    }
    public void deleteAtTail() {
        if(size == 0) {
            return;
        }
        if( size == 1 ) {
            deleteAtHead();
            return;
        }
        Node temp = getNodeAt(size - 2);
        temp.next = null;
        tail = temp;
    }

    public void deleteAt(int idx) {
        if( idx == 0 ) {
            deleteAtHead();
            return;
        }
        if( idx == this.size - 1 ) {
            deleteAtTail();
            return;
        }
        Node temp = getNodeAt(idx - 1);
        temp.next = temp.next.next;
        this.size--;
    }

    public void display() {
        Node temp = this.head;
        while( temp != null ) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    public void removeDuplicates() {
        Node temp = head;
        while(temp.next != null ) {
            if( temp.data == temp.next.data ) {
                temp.next = temp.next.next;
                this.size--;
            }
            else {
                temp = temp.next;
            }
        }
    }

    private class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}

class client {
    public static void main(String[] args) {
        customLL ll = new customLL();
        ll.insertAtHead(10);
        ll.insertAt(20, 1);
        ll.insertAt(30, 2);
        ll.insertAt(40, 3);
        ll.insertAt(50, 4);
        ll.insertAt(50, 5);
        ll.insertAt(50, 6);
        ll.insertAt(60, 7);
        ll.display();
        ll.removeDuplicates();
        ll.display();
    }
}