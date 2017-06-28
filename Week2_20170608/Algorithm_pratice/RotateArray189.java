/*
Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

Note:
Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.

[show hint]
Related problem: Reverse Words in a String II

Credits:
Special thanks to @Freezen for adding this problem and creating all test cases
*/

public class RotateArray189 {
	public void ratate(int[] nums, int k) {
		//special case
		if (nums == null || nums.length <= 1) {
			return;
		}

		//normal case
		/*
		three step swap:
			<---- 0 ~ (len-1) ------>
			a b c d e f g h i j k l m
			<- 0~k-><-(k+1)~(len-1)->
			m l k j i h g f e d c b a
			j k l m a b c d e f g h i
		*/
		k = k % nums.length;
		swap(nums, 0, nums.length - 1);
		swap(nums, 0, k - 1);
		swap(nums, k, nums.length - 1);
	}

	public void swap(int[] nums, int beg, int end) {
		while (beg < end) {
			int temp = nums[beg];
			nums[beg] = nums[end];
			nums[end] = temp;
			beg++;
			end--;
		}
	}
}




























