package rawDataStructure;


public class LinkedList {

	public Node head;

	public LinkedList(Node head2) {
		this.head = head2;
	}

	public void print() {//This will be in infinite loop if circular linked list
		Node current = head;
		StringBuilder out = new StringBuilder();

		while (current != null) {
			out.append("[" + current.data.getData() + "] --> ");
			current = current.next;
		}


		System.out.println(out.toString() + " null");
	}

	public static class Node {//Classic linkedlist doesn't have previous. That's doubly linked list

		public Data data;
		public Node next;

		public Node(Data data) {
			this.data = data;
		}

		public Node(Data data, Node next) {
			this(data);
			this.next = next;
		}
	}

	public static abstract class Data {//Who told you abstract things can't be static?
		public abstract Object getData();
	}
}
