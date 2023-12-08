// palindrome with LL
class Node
{
    int data;
    Node next = null;
 
    Node(int data) {
        this.data = data;
    }
}
 
class Main
{
    // Wrapper over `Node` class
    static class NodeWrapper
    {
        public Node node;
        NodeWrapper(Node node) {
            this.node = node;
        }
    }
    // Helper function to insert a new node at the beginning of the linked list
    public static Node push(Node head, int data)
    {
        Node node = new Node(data);
        node.next = head;
        return node;    // return node, which would be the new head
    }
    // Recursive function to check if the linked list is a palindrome or not
    public static boolean checkPalindrome(NodeWrapper left, Node right)
    {
        // base case
        if (right == null) {
            return true;
        }
        boolean result = checkPalindrome(left, right.next) &&
                            (left.node.data == right.data);
        left.node = left.node.next;
        return result;
    }
    // Function to check if the linked list is a palindrome or not
    public static boolean checkPalin(Node head)
    {
        // Wrap the `head` node, so its reference can be changed inside the
        // `checkPalindrome()`
        return checkPalindrome(new NodeWrapper(head), head);
    }
    public static void main(String[] args)
    {
        int[] keys = {1, 3, 5, 3, 1};
        Node head = null;
        for (int i = keys.length - 1; i >= 0; i--) {
            head = push(head, keys[i]);
        }
        if (checkPalin(head)) {
            System.out.print("The linked list is a palindrome");
        }
        else {
            System.out.print("The linked list is not a palindrome");
        } } }