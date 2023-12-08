// n elements pop linked list 
import java.util.*;
class Node
{
    int data;
    Node next;
 
    Node(int data, Node next)
    {
        this.data = data;
        this.next = next;
    } } 
class Main
{
    public static void printList(Node head){
        Node ptr = head;
        while (ptr != null){
            System.out.print(ptr.data + " —> ");
            ptr = ptr.next;
        }
        System.out.println("null");
    }
// The opposite of `push()`. Takes a non-empty list, removes the front
// node, and prints the data in that node.
    public static Node pop(Node headRef)
    {
        Scanner in=new Scanner(System.in);
        int m=in.nextInt();
        for(int i=1;i<=m;i++)
        {
        // underflow condition
        if (headRef == null) {
            return null;
        }
int result = headRef.data;  // pull out data before the node is deleted
headRef = headRef.next;     // unlink the head node for the caller
       System.out.println("The Popped node is " + result);
        }
        return headRef;
    }
    public static void main(String[] args)
    {
       Scanner in=new Scanner(System.in);
        int x=in.nextInt();
        int keys[]=new int[x];
        for(int i=0;i<x;i++)
        keys[i]=in.nextInt();
        Node head = null;
        for (int i = keys.length - 1; i >= 0; i--) {
            head = new Node(keys[i], head);
        }
        head = pop(head);
        printList(head);
    }
}