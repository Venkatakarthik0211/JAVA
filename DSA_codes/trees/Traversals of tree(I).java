import java.util.Stack;
 
// Data structure to store a binary tree node
class Node
{
    int data;
    Node left, right;
 
    // Function to create a new binary tree node having a given key
    public Node(int key)
    {
        data = key;
        left = right = null;
    }
}
 
class Main
{
    // Iterative function to perform inorder traversal on the tree
    public static void inorderIterative(Node root)
    {
        // create an empty stack
        Stack<Node> stack = new Stack();
    
        // start from the root node (set current node to the root node)
        Node curr = root;
    
        // if the current node is null and the stack is also empty, we are done
        while (!stack.empty() || curr != null)
        {
            // if the current node exists, push it into the stack (defer it)
            // and move to its left child
            if (curr != null)
            {
                stack.push(curr);
                curr = curr.left;
            }
            else {
                // otherwise, if the current node is null, pop an element from
                // the stack, print it, and finally set the current node to its
                // right child
                curr = stack.pop();
                System.out.print(curr.data + " ");
    
                curr = curr.right;
            }
        }
    }
         // Iterative function to perform preorder traversal on the tree
    public static void preorderIterative(Node root)
    {
        // return if the tree is empty
        if (root == null) {
            return;
        }
    
        // create an empty stack and push the root node
        Stack<Node> stack = new Stack();
        stack.push(root);
    
        // loop till stack is empty
        while (!stack.empty())
        {
            // pop a node from the stack and print it
            Node curr = stack.pop();
    
            System.out.print(curr.data + " ");
    
            // push the right child of the popped node into the stack
            if (curr.right != null) {
                stack.push(curr.right);
            }
    
            // push the left child of the popped node into the stack
            if (curr.left != null) {
                stack.push(curr.left);
            }
    
            // the right child must be pushed first so that the left child
            // is processed first (LIFO order)
        }
    }
 
  public static void postorderIterative(Node root)
    {
        // create an empty stack and push the root node
        Stack<Node> stack = new Stack();
        stack.push(root);
    
        // create another stack to store postorder traversal
        Stack<Integer> out = new Stack();
    
        // loop till stack is empty
        while (!stack.empty())
        {
            // pop a node from the stack and push the data into the output stack
            Node curr = stack.pop();
            out.push(curr.data);
    
            // push the left and right child of the popped node into the stack
            if (curr.left != null) {
                stack.push(curr.left);
            }
    
            if (curr.right != null) {
                stack.push(curr.right);
            }
        }
    
        // print postorder traversal
        while (!out.empty()) {
            System.out.print(out.pop() + " ");
        }
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
        System.out.println("Inorder Ilterative soloution");
        inorderIterative(root);
        System.out.println();
             System.out.println(" Pre Ilterative soloution");
        preorderIterative(root);
            System.out.println();
             System.out.println("Post Ilterative soloution");
        postorderIterative(root);
            System.out.println();
    }
}

