package rawDataStructure;

import java.util.function.Function;

public class TwistedArray {

	public final int[] array;
	public Function<Integer, Integer> get; //Wooho java8
	public Function<Void, Integer> size;

	public TwistedArray(int[] array) {
		this.array = array;
	}

	//I have my own simpler version of Function here just in case
	private static abstract class MyFunction<Domain, Range> {
		public abstract Range apply(Domain d);
	}
}
