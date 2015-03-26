package questions.linkedList;

import rawDataStructure.LinkedList;
import rawDataStructure.LinkedList.Data;
import rawDataStructure.LinkedList.Node;
import abstractPackage.IInterviewQuestion;

public class CheckLinkedListPalindrome implements IInterviewQuestion {

	public static void main(String[] args) {
		CheckLinkedListPalindrome test = new CheckLinkedListPalindrome();

		Node head = new Node(new IntData(4));
		head.next = new Node(new IntData(3));
		head.next.next = new Node(new IntData(5));
		head.next.next.next = new Node(new IntData(3));
//		head.next.next.next.next = new Node(new IntData(4));

		test.solve(new LinkedList(head));
	}

	private static class IntData extends Data {

		private final int data;
		private IntData(int data) {
			this.data = data;
		}

		@Override
		public Object getData() {
			return data;
		}
	}

	@Override
	public String getQuestion() {
		return "Check if a linked list is panlindrome.";
	}

	@Override
	public String getClarification() {
		return "Assume no loop in linked list";
	}

	@Override
	public String getExplanation() {
		return "Use two pointers, one runs twice as fast as the other, once the fast one reaches the end of linked list,"
				+ "the slow one will reach the middle of the linked list."
				+ "After that, reverse the second half of the linked list using the pointer found above."
				+ "The rest is just checking if first half is identical to second half";
	}

	@Override
	public void solve(Object abstractInput) {
		LinkedList input = (LinkedList) abstractInput;
		Node head = input.head;
		if (head == null) {
			System.out.println("Is palindrome");//Well length 0 is still palindrome
			return;
		} else if (head.next == null) {
			System.out.println("Is panlindrome");
			return;
		}

		Node slow = head;
		Node fast = head;

		while (fast != null) {
			slow = slow.next;
			fast = fast.next;

			if (fast == null) {
			} else {
				fast = fast.next;
			}
		}

		//Now reverse the linked list
		slow = reverseLinkedList(slow);

		//Now run through the two halves of the list and check if they're identical
		while (slow != null) {
			if (!head.data.getData().equals(slow.data.getData())) {
				System.out.println("Not palindrome");
				return;
			}
			slow = slow.next;
			head = head.next;
		}

		System.out.println("Is palindrome");
	}

	private Node reverseLinkedList(Node head) {
		if (head == null) {
			return null;
		} else if (head.next == null) {
			return head;
		}

		Node previous = null;
		Node current = head;

		while (true) {
			Node next = current.next;
			current.next = previous;
			previous = current;

			if (next == null) {
				break;
			}

			current = next;
		}

		return current;
	}
}
