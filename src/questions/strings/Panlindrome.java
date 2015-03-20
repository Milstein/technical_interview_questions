package questions.strings;

import abstractPackage.IInterviewQuestion;

public class Panlindrome implements IInterviewQuestion {

	public static void main(String[] args) {
		Panlindrome test = new Panlindrome();
		test.solve("");
		test.solve("1");
		test.solve("12321");
		test.solve("racecar");
		test.solve("askdjkalsjdklajskdlj");
		test.solve("1010101010");
		test.solve("10000001");
	}

	@Override
	public String getQuestion() {
		return "Check if a string is a palindrome. E.g. abcba, racecar";
	}

	@Override
	public String getClarification() {
		return null;
	}

	@Override
	public String getExplanation() {
		return "Just do a loop through the first half and compare with the second half";
	}

	@Override
	public void solve(Object abstractInput) {
		String input = (String) abstractInput;
		if (input == null || input.length() <= 1) {
			System.out.println("String is a panlindrome.");//Actually can null string be considered as panlindrome?
			return;
		}

		boolean isPanlindrome = true;
		for (int i = 0; i <= input.length() / 2; i++) {
			if (input.charAt(i) != input.charAt(input.length() - 1 - i)) {
				isPanlindrome = false;
				break;
			}
		}

		System.out.println("String " + input + "is" + (isPanlindrome ? " " : " not ") + "a panlindrome");
	}

}
