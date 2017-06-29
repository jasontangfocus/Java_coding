/*
Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
*/

public class PermutationsII47 {
	 public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		//Base case
		if (nums == null || nums.length == 0) {
			return res;
		}

		//Here inorder to double check the duplicate or visited values in the array, we must first sort the array.
		Arrays.sort(nums);

		helper(res, new ArrayList<Integer>(), new boolean[nums.length], nums);
		return res;
	}

	public void helper(List<List<Integer>> res, List<Integer> path, boolean[] visited, int[] nums) {
		if (path.size() == nums.length) {
			res.add(new ArrayList<Integer>(path));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (visited[i] || (i != 0 && nums[i] == nums[i - 1] && visited[i - 1])) {
				continue;
			}

			path.add(nums[i]);
			visited[i] = true;
			helper(res, path, visited, nums);
			path.remove(path.size() - 1);
			visited[i] = false;
		}
		return;
	}
}