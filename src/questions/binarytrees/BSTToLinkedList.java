package questions.binarytrees;

import rawDataStructure.BinaryTreeNode;
import rawDataStructure.LinkedList;
import abstractPackage.IInterviewQuestion;

public class BSTToLinkedList implements IInterviewQuestion {

	private static LinkedList OUTPUT = null;

	@Override
	public String getQuestion() {
		return "Given a BST, convert it to a sorted linked list (increasing order).";
	}

	@Override
	public String getClarification() {
		return "Expected O(n) run time without any extra space";
	}

	@Override
	public String getExplanation() {
		return "Perform in order traversal and insertion";
	}

	@Override
	public void solve(Object abstractInput) {
		BinaryTreeNode input = (BinaryTreeNode) abstractInput;

		if (input == null) {
			OUTPUT = new LinkedList(null);
			return;
		} else if (input.left == null && input.right == null) {
		}
	}

}
