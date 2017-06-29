/*
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following [1,2,2,null,3,null,3] is not:
    1
   / \
  2   2
   \   \
   3    3
Note:
Bonus points if you could solve it both recursively and iteratively.
*/

//compare two nodes per time
//currently compare left and right
//next compare left.left with right.right AND left.right with right.left
public class SymmetricTree101 {
	public boolean isSymmetric(TreeNode root) {
		//special case
		if (root == null) {
			return true;
		}

		//normal case
		return helper(root.left, root.right);
	}

	public boolean helper(TreeNode left, TreeNode right) {
		//current layer
		if (left == null || right == null) {
			return left == right;
		}
		if (left.val != right.val) {
			return false;
		}

		//next layer 
		return helper(left.left, right.right) && helper(left.right, right.left);
	}
}

//push two initialized nodes
/*public class SymmetricTree101 {
	public boolean isSymmetric(TreeNode root) {
		//special case
		if (root == null) {
			return true;
		}

		//normal case
		Queue<TreeNode> que = new LinkedList<>();
		que.add(root.left);
		que.add(root.right);
		while (!que.isEmpty()) {
			TreeNode left = que.remove();
			TreeNode right = que.remove();

			//current layer
			if (left == null && right == null) {
				continue;
			}
			if (left == null || right == null) {
				return false;
			}
			if (left.val != right.val) {
				return false;
			}

			//next layer
			que.add(left.left);
			que.add(right.right);
			que.add(left.right);
			que.add(right.left);
		}
		return true;
	}
}*/
