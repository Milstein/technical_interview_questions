package abstractPackage;

public interface IInterviewQuestion {
	public String getQuestion();
	public String getClarification();
	public String getExplanation();

	public void solve(Object abstractInput); //Can freely assume that input can be casted to the right type
}