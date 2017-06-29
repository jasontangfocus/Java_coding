/*
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.
*/

public class SearchRotateSortedArray33 {
    public int search(int[] nums, int target) {
    	//special case
    	if (nums == null || nums.length == 0) {
    	    	return -1;
    	}

    	//normal case
    	int minIndx = findMinIdx(nums);
    	if (target == nums[minIndx]) {
    		return minIndx;
    	}
    	int m = nums.length;
    	int start = (target <= nums[m-1]) ? minIndx : 0;
    	int end = (target > nums[m-1]) ? minIndx : m - 1;

    	while (start <= end) {
    		int mid = start + (end - start) / 2;
    		if (nums[mid] == target) {
    			return mid;
    		} else if(target >= nums[mid]) {
    			start = mid + 1;
    		} else {
    			end = mid - 1;
    		}
    	}

    	return -1;
    }

   	public int findMinIdx(int[] nums) {
   		int start = 0, end = nums.length - 1;
   		while (start < end) {
   			int mid = start + (end - start) / 2;
   			if (nums[mid] > nums[end]) {
   				start = mid + 1;
   			} else {
   				end = mid;
   			}
   		}
   		return start;
   	}
}