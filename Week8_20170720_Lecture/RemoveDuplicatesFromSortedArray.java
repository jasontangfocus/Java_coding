/*
Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

For example,
Given input array nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.
*/

public class RemoveDuplicatesFromSortedArray {
	public int removeDuplicates(int[] nums) {
		//Edge Case
		if (nums == null || nums.length == 0) {
			return 0;
		}

		//Normal Case
		if (nums.length == 1) {
			return 1;
		}

		int beg = 0;

		//comapre with second pointer
		for (int i = 0; i < nums.length; i++) {
			if (beg < 1 || nums[i] > nums[beg - 1]) {
				nums[beg] = nums[i];
				beg++;
			}
		}

		return beg;

	}
}


























