// A Linked List Node
class Node
{
    String data;
    Node next;
 
    // Constructor
    Node(String str)
    {
        this.data = str;
        this.next = null;
    }
}
 
class Main
{
    // Function to print a linked list
    public static void printList(Node node)
    {
        while (node != null)
        {
            System.out.print(node.data + " —> ");
            node = node.next;
        }
        System.out.print("null");
    }
 
    // Construct string `s1` and s2 out of the given linked list with consecutive
    // list elements in the forward and backward direction
 
    public static void construct(Node head, StringBuilder s1, StringBuilder s2)
    {
        // base case
        if (head == null) {
            return;
        }
 
        s1.append(head.data);
        construct(head.next, s1, s2);
        s2.append(new StringBuilder(head.data).reverse().toString());
    }
 
    // Function to check if a given linked list of strings is palindromic
    public static boolean isPalindromic(Node head)
    {
        // construct string `s1` with consecutive elements of the linked list
        // construct string `s2` by reversing consecutive elements of the
        // linked list, starting from the end
 
        StringBuilder s1 = new StringBuilder(), s2 = new StringBuilder();
        construct(head, s1, s2);
 
        // check if the linked list is palindromic
        return s1.toString().equals(s2.toString());
    }
 
    public static void main(String[] args)
    {
        Node head = new Node("AA");
        head.next = new Node("XYZ");
        head.next.next = new Node("C");
         head.next.next.next = new Node("D");
        head.next.next.next.next = new Node("C");
        head.next.next.next.next.next  = new Node("ZYX");
        head.next.next.next.next.next.next  = new Node("AA");
 
        System.out.print("Linked List ");
        printList(head);
 
        if (isPalindromic(head)) {
            System.out.print(" is a palindrome.");
        }
        else {
            System.out.print(" is not a palindrome.");
        } } }