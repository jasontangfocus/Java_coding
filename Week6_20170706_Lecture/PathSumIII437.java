/*

You are given a binary tree in which each node contains an integer value.

Find the number of paths that sum to a given value.

The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).

The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.

Example:

root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

Return 3. The paths that sum to 8 are:

1.  5 -> 3
2.  5 -> 2 -> 1
3. -3 -> 11
*/

public class PathSumIII437 {
	//global count 
	int count = 0;
	public int pathSum(TreeNode root, int sum) {
		Map<Integer, Integer> cache = new HashMap<>();
		cache.put(0, 1);
		helper(root, 0, sum, cache);
        return count;
	}

	public void helper(TreeNode root, int curSum, int target, Map<Integer, Integer> cache) {
		//Edge Case
		if (root == null) {
			return;
		}

		//Normal Case
		curSum += root.val;

		if (cache.containsKey(curSum - target)) {
			count += cache.get(curSum - target);
		}

		if (!cache.containsKey(curSum)) {
			cache.put(curSum, 1);
		} else {
			cache.put(curSum, cache.get(curSum) + 1);
		}

		helper(root.left, curSum, target, cache);
		helper(root.right, curSum, target, cache);

		cache.put(curSum, cache.get(curSum) - 1);
	}
}
























