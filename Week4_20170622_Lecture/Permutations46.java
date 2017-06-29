/*
Given a collection of distinct numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]

*/

public class Permutations46 {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		//Base case
		if (nums == null || nums.length == 0) {
			return res;
		}
		//no need to sort the arrays, control based on the index
		//Arrays.sort(nums);
		helper(res, new ArrayList<Integer>(), nums, new boolean[nums.length]);
		return res;
	}

	public void helper(List<List<Integer>> res, List<Integer> path, int[] nums, boolean[] isVisited) {
		//Base case
		if (path.size() == nums.length) {
			res.add(new ArrayList<Integer>(path));
			return;
		}

		//for loop control the current layer
		for (int i = 0; i < nums.length; i++) {
			if (isVisited[i]) {
				continue;
			}
			path.add(nums[i]);
			isVisited[i] = true;
			//invoke self into the next layer
			helper(res, path, nums, isVisited);
			path.remove(path.size() - 1);
			isVisited[i] = false;
		}
		return;
	}
}