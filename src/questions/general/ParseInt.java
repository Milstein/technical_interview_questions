package questions.general;

import abstractPackage.IInterviewQuestion;

public class ParseInt implements IInterviewQuestion {

	public static void main(String[] args) {
		ParseInt test = new ParseInt();
		test.solve("123123");
		test.solve("-12534561243");
		test.solve("0");
		test.solve("-0");
		test.solve("9223372036854775807"); //2^63 - 1
		test.solve("-9223372036854775808"); //-2^63
	}

	@Override
	public void solve(Object abstractInput) {
		String input = (String) abstractInput;

		ParseInt question = new ParseInt();
		System.out.println(question.getQuestion());
		System.out.println(question.getClarification());

		if (!isInteger(input)) {
			throw new IllegalArgumentException("Not an int");
		}

		long output = 0;
		boolean isNegative = input.charAt(0) == '-';

		for (int i = 0; i < input.length(); i++) {
			if (isNegative && i == 0) {
				continue;
			}

			output += input.charAt(i) - '0';
			if (i != input.length() -1) {
				output *= 10;
			} else {
				break;
			}
		}

		if (isNegative) {
			output = -output;
		}


		System.out.println("Converted from " + input + " to integer " + output);
	}

	/**
	 * It depends on the interviewer. We might not be asked to verify if input is valid
	 * @param input
	 * @return is input a valid integer represented as a String
	 */
	private static final boolean isInteger(String input) {
		if (input == null) {
			return false;
		}

		int startIndex = 0;
		if (input.startsWith("-")) {
			startIndex = 1;
		}
		if (input.replaceAll("-", "").isEmpty()) {
			return false;
		}

		for (int i = startIndex; i < input.length(); i++) {
			if (input.charAt(i) < '0' || input.charAt(i) > '9') {
				return false;
			}
		}
		return true;
	}

	@Override
	public String getQuestion() {
		return "Implement a parseInt function";
	}

	@Override
	public String getClarification() {
		return "Here I assume that input is type String, and the integer to be parsed can be contained in a long type";
	}

	@Override
	public String getExplanation() {
		return "Trivial?";
	}

}
