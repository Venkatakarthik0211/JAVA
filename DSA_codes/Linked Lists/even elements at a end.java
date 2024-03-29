//even elements at a end
class Node
{
    int data;
    Node next;
    Node(int data, Node next)
    {
        this.data = data;   this.next = next;
    } }
class Main
{
    public static void printList(String msg, Node head) {
        System.out.print(msg);
        Node ptr = head;
        while (ptr != null) {
            System.out.print(ptr.data + " —> ");
            ptr = ptr.next;
        }
        System.out.println("null");
    }
    // Function to rearrange the given list such that every even node will be
    // moved to the end of the list in reverse order.
    public static Node rearrange(Node head) {
        // empty list
        if (head == null) {
            return null;
        }
        // maintain two lists, odd and even
        Node odd = head;
        Node even = null, prev = null;
        // do for each odd node
        while (odd != null && odd.next != null)
        {
            // "move" next node (which will be even)
            // to the front of even list
            if (odd.next != null)
            {
                Node newNode = odd.next;
                odd.next = odd.next.next;
 
                newNode.next = even;
                even = newNode;
            }
            // update `prev` and move to the next odd node
            prev = odd;
            odd = odd.next;
             }
        // append even list to odd list
        if (odd != null) {
            odd.next = even;
        }
        else {
            prev.next = even;
        }
        return head;  }
    public static void main(String[] args) {
        int[] keys = { 1, 2, 3, 4, 5, 6, 7 };
        Node head = null;
        for (int i = keys.length - 1; i >= 0; i--) {
            head = new Node(keys[i], head);
        }
        printList("Before: ", head);
    // rearrange the references to the given list
        head = rearrange(head);
        printList("After: ", head);
    }}