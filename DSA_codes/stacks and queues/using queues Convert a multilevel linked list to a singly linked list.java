//Convert a multilevel linked list to a singly linked list using queues
//space complexity O(N)
import java.util.ArrayDeque;
import java.util.Queue;

// A Linked List Node
class Node
{
	int data;
	Node next, child;

	Node(int data, Node next, Node child)
	{
		this.data = data;
		this.next = next;
		this.child = child;
	}
}

class Main
{
	// Function to convert a multilevel linked list into a singly linked list
	public static Node convertList(Node head)
	{
		Node curr = head;
		Queue<Node> q = new ArrayDeque<>();

		// process all nodes
		while (curr != null)
		{
			// last node is reached
			if (curr.next == null)
			{
				// dequeue the front node and set it as the next node
				// of the current node
				curr.next = q.poll();
			}

			// if the current node has a child
			if (curr.child != null) {
				q.add(curr.child);
			}

			// advance the current node
			curr = curr.next;
		}

		return head;
	}

	// Helper function to print a given linked list
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

	// Helper function to create a linked list with elements of a given list
	public static Node createHorizontalList(int[] input)
	{
		Node head = null;
		for (int i = input.length - 1; i >= 0; i--) {
			head = new Node(input[i], head, null);
		}
		return head;
	}

	public static void main(String[] args)
	{
		// create a multilevel linked list
		Node head = createHorizontalList(new int[] {1, 2, 3, 4, 5});
		head.child = createHorizontalList(new int[] {6, 7});
		head.next.next.child = createHorizontalList(new int[] {8, 9});
		head.child.next.child = createHorizontalList(new int[] {10, 11});
		head.child.next.child.child = createHorizontalList(new int[] {12});

		convertList(head);
		printList(head);
	}
}