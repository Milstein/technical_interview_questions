package rawDataStructure;

public class BinaryTreeNode {
	public BinaryTreeNode left, right;
	public int data;

	public BinaryTreeNode(BinaryTreeNode left, BinaryTreeNode right, int data) {
		this.left = left;
		this.right = right;
		this.data = data;
	}

	@Override
	public String toString() {//InOrder
		StringBuffer output = new StringBuffer();
		if (left != null) {
			output.append("[" + left.toString() + "]");
		}

		output.append("[" + data+ "]");

		if (right != null) {
			output.append("[" +right.toString()+ "]");
		}

		return output.toString();
	}

	public String preOrder() {//Root --> L --> R
		StringBuffer output = new StringBuffer();

		output.append("[" + data+ "]");

		if (left != null) {
			output.append("[" + left.preOrder() + "]");
		}

		if (right != null) {
			output.append("[" +right.preOrder()+ "]");
		}

		return output.toString();
	}

	public String inOrder() {
		return this.toString();
	}

	public String postOrder() {//L --> R --> Root
		StringBuffer output = new StringBuffer();

		if (left != null) {
			output.append(left.postOrder());
		}

		if (right != null) {
			output.append(right.postOrder());
		}

		output.append(data);

		return output.toString();
	}
}
