//Convert a multilevel linked list to a singly linked list using queues
space complexity O(1)
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
	// Function to find the last node of a linked list
	public static Node findTail(Node head)
	{
		Node tail = head;
		while (tail != null && tail.next != null) {
			tail = tail.next;
		}
		return tail;
	}

	// Function to convert a multilevel linked list into a singly linked list
	public static Node convertList(Node head)
	{
		// find the tail node of the head node
		Node tail = findTail(head);

		// start from the head node
		Node curr = head;

		// process all nodes
		while (curr != null)
		{
			// if the current node has a child
			if (curr.child != null)
			{
				// set the child node as the next node of the tail node
				tail.next = curr.child;

				// update the tail to the last node of the child node
				tail = findTail(curr.child);
			}

			// advance current node
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

	// Helper function to create a linked list with elements of a given array
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