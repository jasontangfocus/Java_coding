/*
Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.

You may assume the integer do not contain any leading zero, except the number 0 itself.

The digits are stored such that the most significant digit is at the head of the list.
*/

public class PlusOne66 {
	public int[] plusOne(int[] digits) {
		//int array 
		//[1,0,3,4] + 1 => [1,0,4,5] last digit smaller than 9, plusone, simply add 1 to the last digit in the array 
		//[1,0,3,9] + 1 => [1,0,4,0] if last digit equal tp 9, add one, then need to carry 1 to the digit before last one, and also need to identify that digit if equal to 9. SO we need a carray.

		//corner case
		if (digits == null) {
			return new int[]{1};
		}

		//normal case
		/*int carry = 0;
		int lengthOld = digits.length; 
		int[] newDigits = new int[lengthOld];
		int index = lengthOld - 1;

		if (digits[digits.length - 1] < 9) {
			digits[digits.length - 1]++;
			return digits;
		} else {
			while(index >= 0) {
				int x = index < 0 ? 0 : digits[index];
				newDigits[index] = ((x + 1) % 10);
				carry = (x + 1 + carry) / 10;
				index--;
			}
			if (carry == 1) {
				
			}
		}
*/		

		int lens = digits.length;
		for (int i = lens - 1; i >= 0; i--) {
			if (digits[i] < 9) {
				digits[i]++;
				return digits;
			}

			digits[i] = 0;
		}

		int[] newDigits = new int[lens + 1];
		newDigits[0] = 1;

		return newDigits;

	}
}