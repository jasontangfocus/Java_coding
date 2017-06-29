/*
Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".

*/

public class FindAllAnagramsInAString438 {
	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> res = new ArrayList<>();
		//special case
		if (s == null || s.length() == 0 || p == null || p.length() == 0) {
			return res;
		}

		//normal case
		int[] map = new int[256];

		for (char cur : p.toCharArray()) {
			map[cur]++;
		}

		int left = 0;
		int right = 0;
		int counter = p.length();

		while (right < s.length()) {

			if (map[s.charAt(right)] > 0) {
				counter--;
			}

			map[s.charAt(right)]--;
			right++;

			if (counter == 0) {
				res.add(left);
			}

			if (right - left == p.length()) {
				if (map[s.charAt(left)] >= 0) {
					counter++;
				}
				map[s.charAt(left)]++;
				left++;
			}
		}

		return res;
	}
}