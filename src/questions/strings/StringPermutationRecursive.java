package questions.strings;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import abstractPackage.IInterviewQuestion;

public class StringPermutationRecursive implements IInterviewQuestion {

	public static void main(String[] args) {
		StringPermutationRecursive test = new StringPermutationRecursive();
		test.solve("a");
		test.solve("ab");
		test.solve("abc");
		test.solve("abcd");
		test.solve("abcde");
		test.solve("abcdef");
		test.solve("abcdefg");
		test.solve("abcdefgh");
		test.solve("abcdefghi");
		test.solve("abcdefghij");
	}

	@Override
	public String getQuestion() {
		return "Print all permutations of a String";
	}

	@Override
	public String getClarification() {
		return "Duplicated permutations are listed multiple times";
	}

	@Override
	public String getExplanation() {
		return "Using recurrence: get first char of the string. Generate all possible permutations of the string without the first char."
				+ "For each generated permutation, generate the original string's permutations by "
				+ "insert the (first) character extracted previously into every places of the generated string."
				+ "E.g. character is x and generated strings are (uv, vu) ---> (xuv, uxv, uvx, xvu, vxu, vux)";
	}

	@Override
	public void solve(Object abstractInput) {
		String input = (String) abstractInput;
		System.out.println("Input string " + input);
		List<String> output = internalSolve(input);
		System.out.println("Found " + output.size() + " permutations.");

//		int count = 0;
//		for (String s : output) {
//			System.out.println("Permutation " + count++ + " is " + s);
//		}
	}

	private List<String> internalSolve(String n) {
		if (n == null) {
			return new LinkedList<String>();
		}

		if (n.length() <= 1) {
			return Arrays.asList(new String[]{n});
		}

		return insert(n.charAt(0), internalSolve(n.substring(1)));
	}

	private List<String> insert(char c, List<String> d) {
		LinkedList<String> output = new LinkedList<String>();

		for (String s : d) {
			for (String gen : singleInsert(c, s)) {
				output.addLast(gen);
			}
		}

		return output;
	}

	private static List<String> singleInsert(char c, String n) {
		if (n.length() == 1) {
			return Arrays.asList(new String[] {c + n, n + c});
		}

		LinkedList<String> output = new LinkedList<String>();
		for (int i = 0; i <= n.length(); i++) {
			output.addLast(n.substring(0, i) + c + n.substring(i));
		}

		return output;
	}
}