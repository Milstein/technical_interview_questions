package questions.bitwise;

import java.util.Arrays;

import abstractPackage.IInterviewQuestion;

public class NonRepeatedElement implements IInterviewQuestion {

	public static void main(String[] args) {
		NonRepeatedElement test = new NonRepeatedElement();
		test.solve(new int[] {1, 1, 2, 2, 3, 3, 4});
		test.solve(new int[] {1, 1, 2, 2, 3, 3, 4, 4, 5});
		test.solve(new int[] {1});
		test.solve(new int[] {-1, -2, -3, -4, -7, -3, -2, -1, -4});
	}

	@Override
	public String getQuestion() {
		return "Given an array of integers in which every element is repeated exactly twice except one element which only has 1 occurence. "
				+ "Find that element in O(n) time and without extra space";
	}

	@Override
	public String getClarification() {
		return null;
	}

	@Override
	public String getExplanation() {
		return "If every element is repeated exactly twice, XORing all of them would give 0 (since 1 XOR 1 = 0 and 0 XOR 0 = 0). The element "
				+ "which has single occurrence would cause the XOR result to be exactly equal to that element.";
	}

	@Override
	public void solve(Object abstractInput) {
		int[] array = (int[]) abstractInput;
		System.out.println("Input array is " + Arrays.toString(array));

		if (array.length == 0) {//Really guys?
			System.out.println("No element in the array");
			return;
		}

		int xor = 0; //Identity x ^ 1 = x so we choose this to start with
		for (int i : array) {
			xor = xor ^ i;
		}

		System.out.println("The element with single occurence is " + xor);
	}

}
