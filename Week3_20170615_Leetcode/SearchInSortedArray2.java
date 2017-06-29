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
A:	{1131} special case

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

        /*Binarysearch*/
        /*if (nums == null || nums.length ==0) {
                return false;
        }
        
        Arrays.sort(nums);
        
        int searchResult = Arrays.binarySearch(nums, target);
        System.out.println(searchResult);
        return searchResult >= 0 ? true : false;
    }*/
}
