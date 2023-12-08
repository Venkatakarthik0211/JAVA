// recursive palindrome with set of characters
class Node
{
    char data;
    Node next;
    Node(char ch)
    {
        this.data = ch;
        this.next = null;
    } }
class Main
{
    // Construct `s1` and `s2` out of the given linked list with consecutive
    // list elements in the forward and backward direction
    public static void construct(Node head, StringBuilder s1, StringBuilder s2)
    {
        // base case
        if (head == null) {
            return;
        }
        s1.append(head.data);
        construct(head.next, s1, s2);
        s2.append(head.data);
    }
    // Function to check if a given linked list of characters is a palindrome
    public static boolean isPalindrome(Node head)
    {
        // construct string `s1` and `s2` with consecutive elements of the linked list
        // starting from the beginning and the end
        StringBuilder s1 = new StringBuilder(), s2 = new StringBuilder();
        construct(head, s1, s2);
        // check if the linked list is a palindrome
        return s1.toString().equals(s2.toString());
    }
    public static void main(String[] args)
    {
        Node head = new Node('A');
        head.next = new Node('B');
        head.next.next = new Node('C');
        head.next.next.next = new Node('B');
        head.next.next.next.next = new Node('A');
        if (isPalindrome(head)) {
            System.out.print("Linked List is a palindrome.");
        }
        else {
            System.out.print("Linked List is not a palindrome.");
        } }  }