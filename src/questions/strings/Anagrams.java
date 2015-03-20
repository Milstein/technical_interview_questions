package questions.strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import abstractPackage.IInterviewQuestion;

public class Anagrams implements IInterviewQuestion {

	public static void main(String[] args) {
		Anagrams test = new Anagrams();
		test.solve(new String[] {"", ""});
		test.solve(new String[] {"a", "a"});
		test.solve(new String[] {"ab", "a"});
		test.solve(new String[] {"aab", "aba"});
		test.solve(new String[] {"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", "aaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaa"});
		test.solve(new String[] {"abcdefghijklmn", new StringBuilder("abcdefghijklmn").reverse().toString()});
	}

	@Override
	public String getQuestion() {
		return "Determine if two Strings are anagrams";
	}

	@Override
	public String getClarification() {
		return null;
	}

	@Override
	public String getExplanation() {
		return "Approach 1: sort both string, then they have to be the same to be anagrams --> O(nlogn) where n is max between 2 string lengths. No extra space used "
				+ "Approach 2: index the first string using hash map, then it's trivial to check if the second string is anagram "
				+ "--> O(n) run time but O(n) space for hash map";
	}

	@Override
	public void solve(Object abstractInput) {
		String[] inputs = (String[]) abstractInput;
		String str1 = inputs[0];
		String str2 = inputs[1];
		System.out.println("Considering two strings " + str1 + " and " + str2);
		if (str1 == null || str2 == null || str1.length() != str2.length()) {
			System.out.println("Two strings are not anagrams");
			return;
		}

		//Approach 1: sort 2 strings
		System.out.println("Using approach 1");
		char[] arrayString1 = str1.toCharArray();
		Arrays.sort(arrayString1); //Hope you know your sorting algorithm well if the interviewer asks

		char[] arrayString2 = str2.toCharArray();
		Arrays.sort(arrayString2);

		boolean isAnagramApproach1 = true;
		for (int i = 0; i < arrayString1.length; i++) {
			if (arrayString1[i] != arrayString2[i]) {
				System.out.println("Two strings are not anagrams");
				isAnagramApproach1 = false;
				break;
			}
		}

		if (isAnagramApproach1) {
			System.out.println("Two strings are anagrams");
		}


		//Approach 2: using hashmap
		System.out.println("Using approach 2");
		//Index first string using hashmap
		Map<Character, Integer> indexing = new HashMap<>();
		for (int i  = 0; i < str1.length(); i++) {
			char c = str1.charAt(i);
			if (!indexing.containsKey(c)) {
				indexing.put(c, 1);
			} else {
				indexing.put(c,  indexing.get(c) + 1);
			}
		}

		//Iterate over second string to check
		for (int i  =0; i < str2.length(); i++) {
			char c = str2.charAt(i);
			if (!indexing.containsKey(c)) {
				System.out.println("Two string are not anagrams");
				return;
			} else {
				int newValue = indexing.get(c) - 1;
				if (newValue == 0) {
					indexing.remove(c);
				} else {
					indexing.put(c, newValue);
				}
			}
		}

		System.out.println("Two strings are anagrams.");
	}
}
