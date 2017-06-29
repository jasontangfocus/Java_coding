/*
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

Note:
You must do this in-place without making a copy of the array.
Minimize the total number of operations.
Credits:
Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.
*/

public class 283_MoveZeros {
	public void moveZeros(int[] nums) {
		//corner case
		if (nums == null || nums.length == 0) {
			return;
		}

		//normal case
		int pre = 0;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				//self defined method swap to move none zero numbers forward
				swap(nums, pre, i);
				pre++;
			}
		}

		return;
	}

	public void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}