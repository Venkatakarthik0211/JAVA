
class Main 
 {
      public static void Main(String args[])
    {
        int keys[] = {1,2,3,4,5,6};
        node head = null;
        for(int key: keys)
        {
            head = append(head,key);
        }
        print(head);
    }
    public static node push(int data, node head)
    {
        node newd = new node();
        newd.data = data;
        newd.next = head;
        return newd;
    }
    public static node append(node head, int key)
    {
        node current = head;
        if(head==null)
        {
            head = push(key,null);
        }
        else
        {
            while(current.next!=null) 
            {
                current = current.next;
                current.next = push(key, null); 
            }
        }
        return head;
    }
    public static void print(node head)
    {
        for (node ptr = head; ptr != null; ptr = ptr.next) {
            System.out.print(ptr.data + " —> ");
        }
        System.out.println("null");
    }
    }
    class node
{
    int data; 
    node next;
}