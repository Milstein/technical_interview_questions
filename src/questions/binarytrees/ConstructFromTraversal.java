package questions.binarytrees;

import java.util.Arrays;

import rawDataStructure.BinaryTreeNode;
import abstractPackage.IInterviewQuestion;

public class ConstructFromTraversal implements IInterviewQuestion {

	public static void main(String[] args) {
		ConstructFromTraversal test = new ConstructFromTraversal();

		Input t1 = new Input(new int[]{1}, new int[]{1});
		Input t2 = new Input(new int[]{2,1,3}, new int[]{1, 2, 3});
		Input t3 = new Input(new int[]{1,2,3}, new int[]{3, 2, 1});
		Input t4 = new Input(new int[]{4,10,3,1,7,11,8,2}, new int[]{7,10,4,3,1,2,8,11});

		test.solve(t1);
		test.solve(t2);
		test.solve(t3);
		test.solve(t4);
	}

	@Override
	public String getQuestion() {
		return "Given in order and preorder traversal of a binary tree, reconstruct that tree";
	}

	@Override
	public String getClarification() {
		return "Assume given two arrays of integers representing the traversals. To be able to represent the tree uniquely, also assume"
				+ "that all elements are different";
	}

	@Override
	public String getExplanation() {
		return "Given two lists "
				+ "L --> Root --> R"
				+ "and Root --> L --> R"
				+ "We can immediately identify the root, then we find root index from the first list, and use that to"
				+ "extract the left and right trees from the two lists. After that use recursion to reconstruct left and"
				+ "right tree";
	}

	@Override
	public void solve(Object abstractInput) {
		Input input = (Input) abstractInput;

		int[] inOrder = input.inOrder; //L --> Root --> R
		int[] preOrder = input.preOrder;//Root --> L --> R

		System.out.println("Input inOrder " + Arrays.toString(inOrder));
		System.out.println("Input preOrder " + Arrays.toString(preOrder));

		if (inOrder == null || preOrder == null || (inOrder.length != preOrder.length) || (inOrder.length == 0)) {//Why u do dis
			return;
		}

		BinaryTreeNode root = internalSolve(inOrder, 0, inOrder.length - 1, preOrder, 0, preOrder.length - 1);
		System.out.println("Reconstructed tree with");
		System.out.println("Inorder: " + root.inOrder());
		System.out.println("Preorder: " + root.preOrder());
		System.out.println("-----------------------------------------");
	}

	public BinaryTreeNode internalSolve(int[] inOrder, int s1, int e1, int[] preOrder, int s2, int e2) {
		if (e1 - s1 != e2 - s2) {
			throw new IllegalArgumentException("Invalid inputs not equal bounds");
		}

		if (s1 == e1) {
			return new BinaryTreeNode(null, null, preOrder[s2]);
		} else if (e1 < s1) {
			return null;
		}

		int root = preOrder[s2];
		//Now find root in inOrder
		int rootIndex = -1;
		for (int i = 0; i <= e1 - s1; i++) {
			if (inOrder[s1 + i] == root) {
				rootIndex = i;
				break;
			}
		}

		//Inorder: L --> Root --> R
		//Preorder: Root --> L --> R
		BinaryTreeNode left = internalSolve(inOrder, s1, s1 + rootIndex - 1, preOrder, s2 + 1, s2 + rootIndex);
		BinaryTreeNode right = internalSolve(inOrder, s1 + rootIndex + 1, e1, preOrder, s2 + rootIndex + 1, e2);
		BinaryTreeNode rootNode = new BinaryTreeNode(left, right, root);

		return rootNode;
	}

	private static class Input {
		private final int[] inOrder, preOrder;

		public Input(int[] inOrder, int[] preOrder) {
			this.inOrder = inOrder;
			this.preOrder = preOrder;
		}
	}
}
