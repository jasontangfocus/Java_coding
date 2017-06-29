/*
Given a set of distinct integers, nums, return all possible subsets.

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]

*/

public class Subsets {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		//Base case
		if (nums == null || nums.length == 0) {
			res.add(new ArrayList<Integer>());
			return res;
		}

		//normal case
		helper(res, new ArrayList<Integer>(), nums, 0);
		return res;
	}

	public void helper(List<List<Integer>> res, List<Integer> path, int[] nums, int pos) {
		res.add(new ArrayList<Integer>(path));

		for (int i = pos; i < nums.length; i++) {
			path.add(nums[i]);
			helper(res, path, nums, i + 1);
			path.remove(path.size() - 1);
		}
		return;
	}
}