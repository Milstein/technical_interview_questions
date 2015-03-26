package questions.general;

import abstractPackage.IInterviewQuestion;

public class TowersOfHanoi implements IInterviewQuestion {

	public static void main(String[] args) {
		TowersOfHanoi test = new TowersOfHanoi();
		test.solve(10);
	}

	@Override
	public String getQuestion() {
		return "Solve the Tower of Hanoi problem for n pecks. "
				+ "Tower of Hanoi problem: http://en.wikipedia.org/wiki/Tower_of_Hanoi";
	}

	@Override
	public String getClarification() {
		return "We name the three pecks 0, 1 and 2, and assume that all disks are on peck 0, and goal is to move everything to peck 2";
	}

	@Override
	public String getExplanation() {
		return "Solve the problem using recursion: Move the top n - 1 disks to the other peck, then move the bottom last disk from src --> dst. Lastly, move the n - 1 disks from the other "
				+ "pecks to the dst pecks.";
	}

	@Override
	public void solve(Object abstractInput) {
		int n = (int) abstractInput;
		internalSolve(n, 0, 2);
	}

	private void internalSolve(int n, int src, int dst) {
		if (n == 1) {
			System.out.println("Move " + src + " to " + dst);
			return;
		}

		int otherPeck = 3 - src - dst;

		internalSolve(n - 1, src, otherPeck);
		System.out.println("Move " + src + " to " + dst);
		internalSolve(n - 1, otherPeck, dst);
	}
}
