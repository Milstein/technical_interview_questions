package questions.linkedList;

import rawDataStructure.LinkedList;
import rawDataStructure.LinkedList.Data;
import rawDataStructure.LinkedList.Node;
import abstractPackage.IInterviewQuestion;

public class ReverseIteratively implements IInterviewQuestion {

	public static void main(String[] args) {
		Node cur = null;
		Node headNode = new Node(new IntData(3));
		cur = headNode;
		cur.next = new Node(new IntData(4));
		cur = cur.next;

		cur.next = new Node(new IntData(5));
		cur = cur.next;

		cur.next = new Node(new IntData(6));
		cur = cur.next;


		ReverseIteratively test = new ReverseIteratively();
		test.solve(headNode);

		headNode.next = new Node(new IntData(4));
		test.solve(headNode);

		headNode = new Node(new IntData(2));
		test.solve(headNode);
	}

	private static class IntData extends Data {

		int data;

		private IntData(int data) {
			this.data = data;
		}

		@Override
		public Integer getData() {
			return data;
		}
	}

	@Override
	public String getQuestion() {
		return "Reverse a linked list iteratively";
	}

	@Override
	public String getClarification() {
		return "Given head node of a linked list as a starting point";
	}

	@Override
	public String getExplanation() {
		return "We just loop through the linked list and flip the pointers to the reverse direction"
				+ "Remember to assume that linked list is not circular. Otherwise this won't work";
	}

	@Override
	public void solve(Object abstractInput) {
		Node head = (Node) abstractInput;

		if (head == null) {//Remember to check this. It's trivial but we usually forget during interview
			System.out.println("Sorry nothing to reverse");
			return;
		}
		System.out.println("Linked list is ");
		new LinkedList(head).print();

		Node current = head;
		Node next = null;
		Node previous = null;

		Node headNode = null;

		while (current != null) {
			next = current.next;
			current.next = previous;

			if (next != null) {
				headNode = next; //Just for printing
			}

			previous = current;
			current = next;
		}

		System.out.println("Reversed linked list is ");
		new LinkedList(headNode).print();
	}
}