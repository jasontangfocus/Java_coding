/*
* Given an array and a value, remove all instances of that value in place and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.

Example:
Given input array nums = [3,2,2,3], val = 3

Your function should return length = 2, with the first two elements of nums being 2.
*/ 


Class 27RemoveElement {
	public int 27_RemoveElement(int[], int val) {
		//corner case
		if (nums == null || nums.length == 0) {
			return 0;	
			//Because the method we use to return int type value, so we can not simply return null here
		}

		//normal case
		int beg = 0;

		for (int i = 0; i < nums.length; i++ ) {
			//Below we move the pointer in circusmatances
			if (nums[i] != val) {
				nums[beg] = nums[i];
				beg++;
			}
		}

		return beg;
	}
}
