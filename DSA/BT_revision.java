import java.util.*; 
class BT 
{
    public BT() {}
    private static class Node 
    {
        int data; 
        Node left, right;
        public Node(int data) 
        {
            this.data = data; 
            //left = right = null;
        }
    }
    private Node root;

    public void populate(Scanner in) 
    {
        int n = in.nextInt();
        root = new Node(n);
        populate(root, in);
    }
    private void populate(Node node, Scanner in) 
    {
        System.out.println("left?: ");
        boolean left = in.nextBoolean();
       
        if(left)
        {
            System.out.println("Enter the value of left child of " + node.data + ":");
            int n = in.nextInt();
            node.left = new Node(n);
            populate(node.left, in);
        }
        System.out.println("right?: ");
        boolean right = in.nextBoolean();
        if(right)
        {
            System.out.println("Enter the value of right child of " + node.data + ":");
            int n = in.nextInt();
            node.right = new Node(n);
            populate(node.right, in);
        }
    }
    public void display(Node node, String indent) 
    {
        if(node == null) return;
        System.out.println(indent + node.data);
        display(node.left, indent + "  ");
        display(node.right, indent + "  ");
    }
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        BT bt = new BT();
        bt.populate(in);
        bt.display(bt.root, "");
    }
}