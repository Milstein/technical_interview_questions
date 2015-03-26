package questions.arrays;

import java.util.Arrays;
import java.util.HashMap;

import abstractPackage.IInterviewQuestion;

public class InplaceRadixSort implements IInterviewQuestion {

	public static void main(String[] args) {
		InplaceRadixSort test = new InplaceRadixSort();
		HashMap<Integer, Character> map = new HashMap<>();
		map.put(1, 'A');
		map.put(2, 'A');
		map.put(3, 'A');
		map.put(4, 'B');
		map.put(5, 'B');
		map.put(6, 'B');
		map.put(7, 'C');
		map.put(8, 'C');
		map.put(9, 'C');

		test.solve(new Input(map, new int[] {9, 2}));
		test.solve(new Input(map, new int[] {9, 4}));
		test.solve(new Input(map, new int[]{1, 7, 4}));
		test.solve(new Input(map, new int[]{1, 2, 4, 3}));
		test.solve(new Input(map, new int[]{9,8,7,6,5,4,3,2,1}));
	}

	@Override
	public String getQuestion() {
		return "Given an array of integers and a map that maps integers to values A, B, and C. Sort the array so that integers "
				+ "mapped to A come before integers mapped to B, and integers mapped to C come last. Run time O(n) and no extra space.";
	}

	@Override
	public String getClarification() {
		return "Assume map is hashmap which ideally gives O(1) lookup";
	}

	@Override
	public String getExplanation() {
		return "Using in place radix sort twice to sort the array (first time to get all integers mapped to A to the left, then all integers mapped to B) "
				+ "In place radix sort: http://en.wikipedia.org/wiki/Radix_sort#In-place_MSD_radix_sort_implementations";
	}

	@Override
	public void solve(Object abstractInput) {
		Input input = (Input) abstractInput;
		HashMap<Integer, Character> map = input.map;
		int[] array = input.array;

		System.out.println("Input array " + Arrays.toString(array));

		//Edge case
		if (array.length == 0 || array.length == 1) {//Really guys?
			System.out.println("Already sorted... " + Arrays.toString(array));
			return;
		}

		//Sort all the As to the left
		int allA = inplaceRadixSort(array, 0, array.length - 1, map, 'A');

		if (allA < array.length) {//Now sort all the Bs and C
			inplaceRadixSort(array, allA, array.length - 1, map, 'B');
		}

		System.out.println("Sorted array: " + Arrays.toString(array));
	}

	/**
	 *
	 * @param array
	 * @param start
	 * @param end
	 * @param map
	 * @param criterion
	 * @return the first index at which the array element is not mapped to criterion (after the array has been sorted)
	 */
	private static int inplaceRadixSort(int[] array, int start, int end, HashMap<Integer, Character> map, char criterion) {
		int left = start;
		int right = end;

		while (left < right) {
			if (map.get(array[left]) == criterion) {//We're good. No need to do anything
				left++;
			} else {//Swap with array[right]
				swap(array, left, right);
				right--;
			}
		}

		//After the loop, we are sure that everything < left is mapped to criterion.
		//We also know that everything > right is NOT mapped to criterion.
		//Lastly, we know left >= right (which ends the while loop), so we just need to check
		//if array[left] is mapped to criterion or not. If it is, just increment left by 1
		if (left < array.length) {
			if (map.get(array[left]) == criterion) {
				left++;
			}
		}

		return left;
	}

	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	private static class Input {
		private final HashMap<Integer, Character> map;
		private final int[] array;

		private Input(HashMap<Integer, Character> map, int[] array) {
			this.map = map;
			this.array = array;
		}
	}
}
