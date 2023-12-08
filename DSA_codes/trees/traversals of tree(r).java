//traversals recurrsive
class Node
{
    int data;
    Node left, right;
    public Node(int key)
    {
        data = key;
        left = right = null;
    }
}
 
class Main
{
    public static void preorder(Node root)
    {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }
    
    public static void Postorder(Node node)
    {
       
        if (node == null)
            return;
        Postorder(node.left);
        Postorder(node.right);
        System.out.print(node.data + " ");
    }
    public static void Inorder(Node node)
    {
        if (node == null)
            return;
        Inorder(node.left);
        System.out.print(node.data + " ");
        Inorder(node.right);
    }
    public static void main(String[] args)
    {
        /* Construct the following tree
                   1
                 /   \
                /     \
               2       3
              /      /   \
             /      /     \
            4      5       6
                  / \
                 /   \
                7     8
        */
 
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);
        System.out.println("Preorder");
        preorder(root);
         System.out.println();
        System.out.println("Inorder");
        Inorder(root);
         System.out.println();
         System.out.println("Postorder"); 
        Postorder(root);
    }
}
