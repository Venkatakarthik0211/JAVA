class Node
{
    int data; Node next = null;
    Node(int data) {
        this.data = data;
    } }
class Main
{
    public static void printList(String msg, Node head)   {
        System.out.print(msg);
        while (head != null)
        {
            System.out.print(head.data + " —> ");
            head = head.next;
        }
        System.out.println("null");
    }
    public static Node reverse(Node head)
    {
        Node prev = null;
        Node current = head;
        Node next;
        while (current != null)
        {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        return head;
    }
    public static Node addDigit(Node head, int digit)
    {
           if (head == null) {
            return head;
        }
        head = reverse(head);
        int carry = digit;
        Node curr = head;
        while (carry > 0)
        {

            int sum = curr.data + carry;

            curr.data = sum % 10;
   
            carry = sum / 10;
           
            if (curr.next == null) {
                break;
            }
   
            curr = curr.next;
        }
      
        if (carry > 0) {
            curr.next = new Node(carry);
        }
     
        head = reverse(head);
        return head;
    }
    public static void main(String[] args)
    {
        Node head = new Node(9);
        head.next = new Node(9);
        head.next.next = new Node(9);
        head.next.next.next = new Node(9);
        head.next.next.next.next = new Node(3);
        int digit = 7;
        printList("Original linked list: ", head);
        head = addDigit(head, digit);
        printList("Resultant linked list: ", head);
    } }