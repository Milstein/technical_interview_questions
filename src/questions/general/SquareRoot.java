package questions.general;

import abstractPackage.IInterviewQuestion;

public class SquareRoot implements IInterviewQuestion {

	public static void main(String [] args) {
		SquareRoot test = new SquareRoot();

		test.solve(-9);
		test.solve(9);
		test.solve(100);
		test.solve(10000);
		test.solve(2147483647);
	}

	@Override
	public String getQuestion() {
		return "Write function to calculate sqrt of a number (let say an int).";
	}

	@Override
	public String getClarification() {
		return "Must not use Math.sqrt() (of course)";
	}

	@Override
	public String getExplanation() {
		return "Using bisection method to find root of equation x^2 = input. Other methods like Newton–Raphson are harder to understand and/or implement. "
				+ "We may also discuss that bisection converges linearly, which is quite slow compare to other methods that can converge in polynomial orders.";
	}

	@Override
	public void solve(Object abstractInput) {
		int input = (int) abstractInput;

		if (input < 0) {
			System.out.println("Negative int doesn't have sqrt");
			return;
		}

		double max = Integer.MAX_VALUE;
		double min = Integer.MIN_VALUE;
		double mid = (max + min) / 2;

		double epsilon = 999999;

		final double EPSILON = 0.0000001;//Lower this to increase precision
		int count = 0;

		while (max > min) {
			count += 1;
			if (mid * mid > input) {//Answer must be to our left
				max = mid;
			} else {
				min = mid;
			}

			double newMid = (max + min) / 2;
			epsilon = Math.abs(newMid - mid);

			//Here I break by epsilon. You can also break by number of iteration (usually 1000 is OK for this simple function)
			if (epsilon < EPSILON) {
				break;
			} else {
				mid = newMid;
			}
		}

		System.out.println("After " + count + " iterations, we approximated sqrt of " + input + " to be " + mid);
	}

}
