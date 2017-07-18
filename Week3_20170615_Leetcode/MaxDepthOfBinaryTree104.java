/*
Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
*/

public class MaxDepthOfBinaryTree104 {
	public int maxDepth(TreeNode root) {
		//Edge Case
		if (root == null) {
			return 0;
		}

		//Normal Case
		int maxDepthCount = Math.max(maxDepth(root.left), maxDepth(root.right));
		//until each new opened layer to the end leaf, if root equals to root.left or right both null, then it is leaf, will return a 0 + 1. End current layer, back to the previous layer, go into the root.right layer, finally compare and get the bigger one
		return maxDepthCount + 1;
	}
}