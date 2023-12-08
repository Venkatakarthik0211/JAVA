import java.util.*;
 class Main
 { 
    static Node insertBegin(Node head,int data){
        Node temp=new Node(data);
        temp.next=head;
        if(head!=null)
            head.prev=temp;
        return temp;
    }
    
        static Node insertEnd(Node head,int data){
        Node temp=new Node(data);
        if(head==null)return temp;
        Node curr=head;
        while(curr.next!=null){
            curr=curr.next;
        }
        curr.next=temp;
        temp.prev=curr;
        return head;
    }
    public static void InsertAfter(Node prev_Node, int new_data)
	{
		if (prev_Node == null) {
			System.out.println("The given previous node cannot be NULL ");
			return;
		}
		Node temp = new Node(new_data);
		temp.next = prev_Node.next;
		prev_Node.next = temp;
		temp.prev = prev_Node;
		if (temp.next != null)
			temp.next.prev = temp;
	}
	
	 public static void InsertBefore(Node prev_Node, int new_data)
	{
		if (prev_Node == null) {
			System.out.println("The given previous node cannot be NULL ");
			return;
		}
		Node temp = new Node(new_data);
		temp.next = prev_Node.next;
		prev_Node.next = temp;
		temp.prev = prev_Node;
		if (temp.next != null)
			temp.prev.next = temp;
	}
	
	    static Node delHead(Node head)
	    {
        if(head==null)
        return null;
        if(head.next==null)
        {
            return null;
        }    
        else{
          Node temp=head.next;
           temp.prev = null;
           head.next = null;
            return temp;
        }
    }
    
    public static Node delLast(Node head){
        if(head==null)return null;
        if(head.next==null){
            return null;
        }    
        Node curr=head;
        while(curr.next!=null)
            curr=curr.next;
        curr.prev.next=null;
        curr.prev = null;
        return head;
    }
    
    public static Node deleteNode(int position, Node head)
    {
        if (head == null)
            return null;
        
        Node temp = head;
    if (position == 0)
        {
            head = temp.next;
            return head;
        }
        for (int i=0; temp!=null && i<position-1; i++)
            temp = temp.next;
        if (temp == null || temp.next == null)
            return null;
        Node next = temp.next.next;
        temp.next = next;
        return head;
    }
    
     public static Node deleteAfterNode(int position, Node head)
    {
        if (head == null)
            return null;
        
        Node temp = head;
    if (position == 0)
        {
            head = temp.next;
            return head;
        }
        for (int i=0; temp!=null && i<position-1; i++)
            temp = temp.next;
        if (temp == null || temp.next == null)
            return null;
        Node next = temp.next.next;
        temp.next = next;
        return head;
    }
    
        public static Node deleteBeforeNode(int position, Node head)
    {
        if (head == null)
            return null;
        Node temp = head;
    if (position == 0)
        {
            head = temp.next;
            return head;
        }
        for (int i=0; temp!=null && i<position-2; i++)
            temp = temp.next;
        if (temp == null || temp.next == null)
            return null;
        Node next = temp.next.next;
        temp.next = next;
        return head;
    }
    
    public static void printlist(Node head){
        Node curr=head;
        while(curr!=null){
        System.out.print(curr.data+" ");
        curr=curr.next;
    }System.out.println();
    }
    
        public static void Find(Node head , int x){
        Node curr=head;
        while(curr!=null)
        {
            if(x==curr.data)
            {
            System.out.println(curr.data+" is found");
            curr=curr.next;
            break;
            }
             System.out.println("The given input is not found");
        }  
    System.out.println();
      }
      
          public static Node Replace(int position, Node head)
    {
        if (head == null)
            return null;
        
        Node temp = head;
    if (position == 0)
        {
            head = temp.next;
            return head;
        }
        for (int i=0; temp!=null && i<position-2; i++)
            temp = temp.next;
        if (temp == null || temp.next == null)
            return null;
        int x=200;
        Node next = temp.next;
        temp.next.data=x;
        temp.next = next;
        return head;
    }
    
    public static void main(String args[]) 
    { 
        Node head=new Node(10);
    	Node temp1=new Node(20);
    	Node temp2=new Node(30);
    	head.next=temp1;
    	temp1.prev=head;
    	temp1.next=temp2;
    	temp2.prev=temp1;
    	head=insertBegin(head,0);
    	System.out.println("insertion at beginning");
    	printlist(head);
    	head=insertBegin(head,-10);
    	System.out.println("insertion at beginning");
    	printlist(head);
    	head=insertEnd(head,40);
    	System.out.println("insertion at end");
    	printlist(head);
    	head=insertEnd(head,50);
    	System.out.println("insertion at end");
    	printlist(head);
    	System.out.println("insertion after node");
    	InsertAfter(head.next, 8);
    	printlist(head);
    	System.out.println("insertion before node");
    	InsertAfter(head, -8);
    	printlist(head);
    	System.out.println("delete beginning node");
    	head=delHead(head);
    	printlist(head);
    	System.out.println("delete end node");
    	head=delLast(head);
    	printlist(head);
    	System.out.println("delete at a node");
    	int n = 2;
    	head = deleteNode(n, head);
		printlist(head);
		System.out.println("delete after a node");
    	n = 2;
    	head = deleteAfterNode(n, head);
		printlist(head);
		n = 2;
		System.out.println("delete before a node");
    	head = deleteBeforeNode(n, head);
		printlist(head);
		System.out.println("traverse of a node");
		printlist(head);
		System.out.println("Find a node");
		int x = -8;
		Find(head,x);
		System.out.println("Replace a node");
    	n = 2;
    	head = Replace(n , head );
		printlist(head);
    } 
}

class Node{
        int data;
        Node prev;
        Node next;
        Node(int d){
            data=d;
           prev=null;
            next=null;
        }
    }