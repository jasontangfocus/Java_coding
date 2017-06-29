/*
Given a collection of integers that might contain duplicates, nums, return all possible subsets.

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
*/

public class SubsetsII90 {
	public List<List<Integer>> subsetsWithDup(int[] nums){
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		//Base case
		if (nums == null || nums.length == 0) {
			res.add(new ArrayList<Integer>());
			return res;
		}

		Arrays.sort(nums);
		helper(res, new ArrayList<Integer>(), nums, 0);
		return res;
	}

	public void helper(List<List<Integer>> res, List<Integer> path, int[] nums, int pos){
		res.add(new ArrayList<Integer>(path));

		for (int i = pos; i < nums.length; i++) {
			if (i != pos && nums[i] == nums[i - 1]) {
				continue;
			}

			path.add(nums[i]);
			helper(res, path, nums, i + 1);
			path.remove(path.size() - 1);
		}
		return;
	}
}