public class PathSumII_113_SecondMethod {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> res = new ArrayList<>();
		//Edge Case
		if (root == null) {
			return res;
		}

		helper(result, new ArrayList<>(), root, sum);
		return result;
	}

	public void helper(List<List<Integer>> res, List<Integer> path, TreeNode root, int sum){
		if (root == null) {
			return;
		}

		path.add(root.val);

		if (root.left == null && root.right == null && sum == root.val) {
			res.add(new ArrayList<>(path));
			path.remove(path.size() - 1);
			return;
		}

		helper(res, path, root.left, sum - root.val);
		helper(res, path, root.right, sum - root.right);
		path.remove(path.size() - 1);

		return;
	}
}