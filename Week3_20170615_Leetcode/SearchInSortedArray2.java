/*
Follow up for "Search in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Write a function to determine if a given target is in the array.

The array may contain duplicates.
*/

/*

Q:	if there are duplicate numbers existed in the array
A:	the boundary duplicates will not affect the choose of the mid value. 
	
	Then we can use the midIdx to determin the target index in the given rotated array if existed.


*/
public class SearchInSortedArray2 {
	public boolean search(int[] nums, int target) {
        //special case
        if (nums == null || nums.length ==0) {
            return false;
        }
        
        //normal 
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return true;
            } else {
                continue;
            }
        }
        
        return false;
    }
}