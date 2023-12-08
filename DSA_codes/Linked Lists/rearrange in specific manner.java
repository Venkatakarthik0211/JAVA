// rearrange alternatively 
class Node
{
    int data; Node next;
    public Node(int data, Node next)
    {
        this.data = data; this.next = next;
    }
    public Node() {}
}
class Main
{
    public static void printList(Node head)  {
        Node ptr = head;
        while (ptr != null)
        {
            System.out.print(ptr.data + " —> ");
            ptr = ptr.next;
        }
        System.out.println("null");
    }
    // Helper function to insert a new node at the beginning of the linked list
    public static Node push(Node head, int data) {
        return new Node(data, head);
    }
    // Function to rearrange the linked list in a specific manner
    public static Node rearrange(Node head)
    {
        // empty list or one node
        if (head == null || (head).next == null) {
            return head;
        }
        // create two dummy nodes
        Node dummyFirst = new Node();
        Node dummySecond = new Node();
        // tail pointer for the first and second list
        Node first = dummyFirst;
        Node second = dummySecond;
        Node curr = head;
        // iterate through the list and process two nodes at a time
        while (curr != null)
        {
            // move the current node to the first list
            first.next = curr;
            first = first.next;
            // move the next node to the second list
            if (curr.next != null)
            {
                second.next = curr.next;
                second = second.next;
                curr = curr.next;
            }
            curr = curr.next;
        }
        // combine the first list with the second list
        first.next = dummySecond.next;
        second.next = null;
        // fix head pointer
        head = dummyFirst.next; 
        return head;
    }
    public static void main(String[] args) {
        int[] keys = { 1, 2, 3, 4, 5 };
        int n = keys.length;
        Node head = null;
        for (int i = n - 1; i >= 0; i--) {
            head = push(head, keys[i]);
        }
        head = rearrange(head);
        printList(head);
} }