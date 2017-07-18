/*
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]
*/

public class PathSumII_113 {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		//Traverse the tree, if the current node bigger than the target sum, then skip this node
		//for each node, substract this node from the sum and save the path in the temp list. If it finally reaches 0, then save it to the result list.
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();
		helper(root, result, temp, sum);
		return result;
	}

	public List<List<Integer>> helper(TreeNode root, List<List<Integer>> result,List<Integer> temp, int sum) {
		//Edge Case
		if (root == null) {
			return result;
		}

		//adding the current node to the temporary list preparing beforehead for the result list
		temp.add(root.val);

		//if root value == sum, and root does not have either left and right children, add the root to the result list
		if (root.left == null && root.right == null &&root.val == sum) {
			result.add(new ArrayList<Integer>(temp));
			return result;
		}

		//if the root has the left branch, put the left child of the root to be the root and go into next recrusive level 
		if (root.left != null) {
			helper(root.left, result, temp, sum - root.val);
			temp.remove(temp.size() - 1);
		}

		//if the root has the right branch 
		if (root.right != null) {
			helper(root.right, result, temp, sum - root.val);
			temp.remove(temp.size() - 1);
		}


	}
}