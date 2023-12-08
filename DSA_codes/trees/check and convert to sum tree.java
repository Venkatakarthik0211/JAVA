//check and convert into sumtree
class Node
{
    int data;
    Node left = null, right = null;
 
    Node(int data) {
        this.data = data;
    }
}
 
class Main
{
    // Function to print preorder traversal of a given tree
    public static void preorder(Node root)
    {
        if (root == null) {
            return;
        }
 
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }
 
    // Recursive function to in-place convert the given binary tree into its
    // sum tree by traversing the tree in a postorder manner
    public static int convertToSumTree(Node root)
    {
        // base case: empty tree
        if (root == null) {
            return 0;
        }
 
        // recursively convert the left and right subtree first before
        // processing the root node
        int left = convertToSumTree(root.left);
        int right = convertToSumTree(root.right);
 
        // stores the current value of the root node
        int old = root.data;
 
        // update root to the sum of left and right subtree
        root.data = left + right;
 
        // return the updated value + the old value (sum of the tree rooted at
        // the root node)
        return root.data + old;
    }
    
    // Recursive function to check if a given binary tree is a sum tree or not
    public static int isSumTree(Node root)
    {
        // base case: empty tree
        if (root == null) {
            return 0;
        }
 
        // special case: leaf node
        if (root.left == null && root.right == null) {
            return root.data;
        }
 
        // if the root's value is equal to the sum of all elements present in its
        // left and right subtree
        if (root.data == isSumTree(root.left) + isSumTree(root.right)) {
            return 2 * root.data;
        }
 
        return Integer.MIN_VALUE;
    }
 
 
    public static void main(String[] args)
    {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);
        
          if (isSumTree(root) != Integer.MIN_VALUE) {
            System.out.print("Binary tree is a sum tree");
        }
        else {
            System.out.print("Binary tree is not a sum tree");
       System.out.println();
        System.out.println("Conversion into sum tree");
        convertToSumTree(root);
        preorder(root);
        }
      System.out.println();
    }
}


