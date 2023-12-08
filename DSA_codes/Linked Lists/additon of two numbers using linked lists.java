class Node
{
    int data;
    Node next;
 
    Node(int data, Node next)
    {
        this.data = data;
        this.next = next;
    }
}
 
class Main
{

    public static void printList(Node head)
    {
        Node ptr = head;
        while (ptr != null)
        {
            System.out.print(ptr.data + " —> ");
            ptr = ptr.next;
        }
 
        System.out.println("null");
    }
 

    public static Node reverse(Node head)
    {
        Node out = null;
        Node current = head;
 

        while (current != null)
        {
  
            Node next = current.next;
 
      
            current.next = out;
            out = current;

            current = next;
        }
 
        return out;
    }
 

    public static Node add(Node X, Node Y)
    {
        Node head = null;
 

        Node prevNode = null;
 

        int carry = 0;
 

        while (X != null || Y != null)
        {

            int sum = 0;
            if (X != null) {
                sum += X.data;
            }
            if (Y != null ) {
                sum += Y.data;
            }
            sum += carry;

            carry = sum / 10;
            sum = sum % 10;
 
    
            Node node = new Node(sum, null);
 
 
            if (head == null)
            {
      
                prevNode = node;
                head = node;
            }
            else {
              
                prevNode.next = node;
 
     
                prevNode = node;
            }
 
    
            if (X != null) {
                X = X.next;
            }
 
            if (Y != null) {
                Y = Y.next;
            }
        }
 
        if (carry != 0) {
            prevNode.next = new Node(carry, prevNode.next);
        }
 
        return head;
    }
 

    public static Node addLists(Node X, Node Y)
    {
    
        X = reverse(X);
        Y = reverse(Y);
 
        return reverse(add(X, Y));
    }
 
    public static void main(String[] args)
    {
        int x = 5734;
        int y = 946;
 
    
        Node X = null;
        while (x != 0)
        {
            X = new Node(x % 10, X);
            x = x/10;
        }
 

        Node Y = null;
        while (y != 0)
        {
            Y = new Node(y % 10, Y);
            y = y/10;
        }
 
        printList(addLists(X, Y));
    }
}



