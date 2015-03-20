package questions.arrays;

import java.util.function.Function;

import rawDataStructure.TwistedArray;
import abstractPackage.IInterviewQuestion;

public class BinarySearchRotated implements IInterviewQuestion {

	private static int FINDING_NUMBER = 5;

	public static void main(String[] args) {
		BinarySearchRotated test = new BinarySearchRotated();

		test.solve(new int[]{4,5,6,7,8,1,2,3});
		test.solve(new int[]{4, 7});
		test.solve(new int[]{4,5,6,7,8,1,2,3, 4, 4, 4, 4});
		test.solve(new int[]{5, 5,5, 4, 5, 5});
		test.solve(new int[]{4,5,6,7,8,1});
	}

	@Override
	public String getQuestion() {
		return "Implement binary search in a rotated array (ex. {5,6,7,8,1,2,3})";
	}

	@Override
	public String getClarification() {
		return "Let's assume integer array for example.";
	}

	@Override
	public String getExplanation() {
		return "We have to determine where the smallest element is, and then reindex our array accordingly. "
				+ "There's a simple trick to do this reindexing";
	}

	@Override
	public void solve(Object abstractInput) {
		int[] array = (int[]) abstractInput;
		if (array == null || array.length == 0) {//Really?
			return;
		} else if (array.length == 1) {
			if (array[0] == FINDING_NUMBER) {
				System.out.println("Found number " + FINDING_NUMBER + " at index 0");
			} else {
				System.out.println("Cannot find number " + FINDING_NUMBER);
			}
			return;
		}

		//Step 1: determine where the smallest element is using binary search.
		final int startIndex = getStartIndex(array);

		//That was binary search for startIndex, which takes O(log(n))
		//Step 2: reindex the array
		final TwistedArray reIndex = new TwistedArray(array);
		reIndex.get = new Function<Integer, Integer>() {
			@Override
			public Integer apply(Integer index) {
				return reIndex.array[(index + startIndex) % reIndex.array.length];
			}
		};

		//Step 3: search using the reindexed array
		//This takes another O(log(n)). In conclusion, our program runs with O(2log(n)) = O(log(n))
		int max = array.length -1;
		int min = 0;
		int mid = (max + min) / 2;

		while (max > min + 1) {
			if (reIndex.get.apply(mid) > FINDING_NUMBER) {
				max = mid;
			} else if (reIndex.get.apply(mid) < FINDING_NUMBER) {
				min = mid;
			} else if (reIndex.get.apply(mid) == FINDING_NUMBER) {
				int realIndex = (mid + startIndex) % array.length;
				System.out.println("Finding number " + FINDING_NUMBER + ". Found index " + realIndex);
				return;
			}

			mid = (max + min) / 2;
		}
		System.out.println("Cannot find number " + FINDING_NUMBER);
	}

	private int getStartIndex(int[] array) {
		//Since the array is rotated, we should always keep max < middle and min > middle
		int max = array.length - 1;
		int min = 0;
		int mid = (max + min) / 2;

		while (max > min + 1) {
			if (array[mid] > array[max]) {//The start point should be to our right?
				min = mid;
			} else {//The start point should be to our right?
				max = mid;
			}
			mid = (max + min) / 2;
		}

		//This might be slightly incorrect. Do a sanity check
		int startIndex = array[mid + 1] < array[mid] ? mid + 1 : mid;
		System.out.println("Found starting index is " + startIndex);
		return startIndex;
	}
}
