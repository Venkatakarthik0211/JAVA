class Main
{
 
static class Node
{
    int data;
    Node next;
    Node prev;
};
 
static Node add(Node rear, int data)
{
    if (rear != null)
    return rear;
    Node temp = new Node();
    temp.data = data;
    rear = temp;
    rear.next = rear;
    return rear;
}
static Node addBegin(Node rear, int data)
{
    if (rear == null)
        return add(rear, data);
 
    Node temp = new Node();
 
    temp.data = data;
    temp.next = rear.next;
    rear.next = temp;
 
    return rear;
}
 
static Node addEnd(Node rear, int data)
{
    if (rear == null)
        return add(rear , data);
     
    Node temp = new Node();
 
    temp.data = data;
    temp.next = rear.next;
    rear.next = temp;
    rear = temp;
 
    return rear;
}
 
static void addafter(Node rear ,int value1,	int value2)
{
	Node new_node = new Node();
	new_node.data = value1; 
	Node temp = rear;
	while (temp.data != value2)
		temp = temp.next;
	Node next = temp.next;
	temp.next = new_node;
	new_node.prev = temp;
	new_node.next = next;
	next.prev = new_node;
}


static void addbefore(Node rear ,int value1,	int value2)
{
	Node new_node = new Node();
	new_node.data = value1;
	Node temp = rear;
	while (temp.next.data != value2)
		temp = temp.next;
	Node next = temp.next;
	temp.next = new_node;
	new_node.prev = temp;
	new_node.next = next;
	next.prev = new_node;
}


    static Node deleteKth(Node head,int k){
        if(head==null)return head;
        if(k==1)return deleteHead(head);//
        Node curr=head;
        for(int i=0;i<k-2;i++)//0,1
    {
            curr=curr.next;
    }
        curr.next=curr.next.next;
        return head;
    }
    
        static Node deleteafter(Node head,int k){
        if(head==null)return head;
        if(k==1)return deleteHead(head);//
        Node curr=head;
        for(int i=0;i<k-1;i++)//0,1
    {
            curr=curr.next;
    }
        curr.next=curr.next.next;
        return head;
    }
    
        static Node deletebefore(Node head,int k){
        if(head==null)return head;
        if(k==1)return deleteHead(head);//
        Node curr=head;
        for(int i=0;i<k-3;i++)//0,1
    {
            curr=curr.next;
    }
        curr.next=curr.next.next;
        return head;
    }
    static Node deleteHead(Node head){
        if(head==null)return null;
        if(head.next==head)
            return null;
        head.data=head.next.data;
        head.next=head.next.next;
        return head;
    }
static Node deletetail(Node head)
{
    Node current = head, temp = head, previous = null;
    if (head == null)
    {
        System.out.printf("\nList is empty\n");
        return null;
    }
    if (current.next == current)
    {
        head = null;
        return null;
    }
    while (current.next != head)
    {
        previous = current;
        current = current.next;
    }
  
    previous.next = current.next;
    head = previous.next;
      
    return head;
}

    public static void traverse(Node head){
        if(head==null)return;
        System.out.print(head.data+" ");
        for(Node r=head.next;r!=head;r=r.next)
            System.out.print(r.data+" ");
    }
    
        public static void find(Node head,int x)
        {
             int count = 0;
        if(head==null)
        return;
        for(Node r=head.next;r!=head;r=r.next)
        if(r.data==x)
        {
            count=count+1;
             break;
        }
        if(count==0)
        System.out.println("DATA NOT FOUND");
        else 
         System.out.println("DATA FOUND");
    }     
    
     public static void replace(Node head,int k,int x)
        {
        if(head==null)
        return;
        for(Node r=head.next;r!=head;r=r.next)
        if(r.data==k)
        {
            r.data=x;
             break;
        }
    }     
       
    
            
public static void main(String[] args)
{
    Node rear = null;
 
    rear = add(rear, 1);
    System.out.println("adding a node ");
    traverse(rear);
    rear = addBegin(rear, 2);
     System.out.println("adding a node at beginning ");
    traverse(rear);
    rear = addBegin(rear, 3);
    System.out.println("adding a node at beginning ");
    traverse(rear);
    rear = addEnd(rear, 4);
    System.out.println("adding a node at the end ");
    traverse(rear);
    rear = addEnd(rear, 5);
    System.out.println("adding a node at the end");
    traverse(rear);
    addafter(rear,6,2);
    System.out.println("adding after a node ");
    traverse(rear);
    addafter(rear,7,2);
    System.out.println("adding after a node ");
    traverse(rear);
    addbefore(rear,8,2);
    System.out.println("adding before a node ");
    traverse(rear);
    addbefore(rear,9,2);
    System.out.println("adding before a node ");
    traverse(rear);
    System.out.println("final traversal");
    traverse(rear);
     System.out.println("delete at a node");
    rear=deleteKth(rear,3);
    traverse(rear);
    System.out.println("delete after a node");
    rear=deleteafter(rear,3);
    traverse(rear);
    System.out.println("delete before a node");
    rear=deletebefore(rear,3);
    traverse(rear);
    System.out.println("delete head node");
    rear=deleteHead(rear);
    traverse(rear);
    System.out.println("delete tail or rear node");
    rear=deletetail(rear);
    traverse(rear);
     System.out.println("find node");
    int k=1;
    find(rear,k);
        System.out.println("replace node");
    k=1;
    int x = 200;
     replace(rear,k,x);
     traverse(rear);
}
}