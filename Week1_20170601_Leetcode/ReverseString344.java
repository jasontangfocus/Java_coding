/*
Write a function that takes a string as input and returns the string reversed.

Example:
Given s = "hello", return "olleh".
Given s = "hello1", return "1olleh".

*/

public class ReverseString344 {
	public String reverseString(String s) {
		//corner case
		if (s ==null) {
			return null;
		}

		//normal case
		//first we transform the String to the Char array 
		char[] newString = s.toCharArray();

		for (int i = 0, j = (newString.length - 1); i < j; i++, j--) {
				char temp = newString[j];
				newString[j] = newString[i];
				newString[i] = temp;
		}

		return new String(newString);
	}
}