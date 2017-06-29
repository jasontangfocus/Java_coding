/*
Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?
*/

public class 242ValidAnagram {
	public boolean isAnagram(String s, String t) {
		//corner case
		if (s.equals(t)) {
			return true;
		}

		if (s.length() != t.length()) {
			return false;
		}

		//normal case
		//here we use HashMap

		Map<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < s.length(); i++) {
			map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
			map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) - 1);
		}

		for (int cur : map.values()) {
			if (cur != 0) {
				return false;
			}
		}

		return true;
	}
}

//*****************Version 2******************
/*public class 242_ValidAnagram {
	public boolean isAnagram(String s, String t) {
		//corner case
		if (s.equals(t)) {
			return true;
		}

		if (s.length() != t.length()) {
			return false;
		}

		//normal case
		//here we use ASCII code to transform to int[] array
		int[] map = new int[128];
		for (int i = 0; i < length(); i++) {
			map[s.charAt(i) - 'a']++;
			map[t.charAt(i) - 'a']--;
		}
		for (int cur : map) {
			if (cur != 0) {
				return false;
			}
		}
		return true;
	}
}*/