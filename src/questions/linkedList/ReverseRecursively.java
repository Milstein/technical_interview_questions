package questions.linkedList;

import rawDataStructure.LinkedList;
import rawDataStructure.LinkedList.Data;
import rawDataStructure.LinkedList.Node;
import abstractPackage.IInterviewQuestion;

public class ReverseRecursively implements IInterviewQuestion {

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


		ReverseRecursively test = new ReverseRecursively();
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
		return "Reverse a linked list recursively";
	}

	@Override
	public String getClarification() {
		return "Basically reverse the first node, then call recursion";
	}

	@Override
	public String getExplanation() {
		return null;
	}

	@Override
	public void solve(Object abstractInput) {
		Node head = (Node) abstractInput;

		System.out.println("Intial linked list is ");
		new LinkedList(head).print();
		new LinkedList(internalSolve(head, null)).print();
	}

	private Node internalSolve(Node head, Node previous) {
		//When we approach a recursive problem, we have to think simple.
		//Recusion makes everything simple if done right, so if we realize that we're doing something complicated, we're doing it wrong

		if (head == null) {
			return previous;
		}

		Node next = head.next;
		head.next = previous;
		return internalSolve(next, head);
	}
}
